package com.bc.album.infrastructure.rest.spring.resource;

import java.util.List;

import com.bc.album.domain.port.in.AlbumsService;
import com.bc.album.domain.port.in.EnrichService;
import com.bc.album.infrastructure.rest.spring.dto.AlbumDto;
import com.bc.album.infrastructure.rest.spring.mapper.AlbumsMapper;
import com.bc.album.infrastructure.rest.spring.spec.AlbumsApi;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiParam;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

/**
 * AlbumsResource class. Rest controller albums resource.
 * In com.bc.album.infrastructure.rest.spring.resource.
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so.
 *
 * @author Álvaro Carmona
 * @since 22/01/2024
 */
@RequiredArgsConstructor
@RestController
@Log4j2
@Api(tags = {"Albums Information"})
public class AlbumsResource implements AlbumsApi {

    private final AlbumsService service;

    private final EnrichService enrichService;

    private final AlbumsMapper mapper;

    /**
     * {@inheritDoc}
     */
    @Override
    public ResponseEntity<List<AlbumDto>> getAlbums(
            @ApiParam(required = true) @RequestHeader(value = "X-B3-TraceId") String xB3TraceId,
            @ApiParam(required = true) @RequestHeader(value = "Authorization") String authorization
           ) {
        TimedRequest<Void, List<AlbumDto>> timedRequest = new TimedRequest<>("albums", null);
        return ResponseEntity.ok(timedRequest.handle(() -> mapper.map(service.getAlbums())));
    }

    /**
     * {@inheritDoc}
     */
    public ResponseEntity<List<AlbumDto>> getEnrichmentAlbums(
            @ApiParam(required = true) @RequestHeader(value = "X-B3-TraceId") String xB3TraceId,
            @ApiParam(required = true) @RequestHeader(value = "Authorization") String authorization
    ) {
        TimedRequest<Void, List<AlbumDto>> timedRequest = new TimedRequest<>("enrich", null);
        return ResponseEntity.ok(timedRequest.handle(() -> mapper.map(enrichService.enrich(false))));
    }

    /**
     * {@inheritDoc}
     */
    public ResponseEntity<Void> postEnrichmentAlbums(
            @ApiParam(required = true) @RequestHeader(value = "X-B3-TraceId") String xB3TraceId,
            @ApiParam(required = true) @RequestHeader(value = "Authorization") String authorization
    ) {
        log.info("Persist enriching call on the fly");
        enrichService.enrich(true);
        log.info("Persist enriching call ended");
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

}
