package com.bc.album.infrastructure.rest.spring.resource;

import com.bc.album.domain.operational.Album;
import com.bc.album.domain.port.in.AlbumsService;
import com.bc.album.infrastructure.rest.spring.dto.AlbumDto;
import com.bc.album.infrastructure.rest.spring.mapper.AlbumsMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.http.ResponseEntity;
import java.util.List;
import static org.mockito.ArgumentMatchers.anyList;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

@RunWith(MockitoJUnitRunner.class)
public class AlbumsResourceTest {

    @Mock
    private AlbumsService service;

    @Mock
    private AlbumsMapper mapper;

    @InjectMocks
    private AlbumsResource resource;

    @Mock
    private Album album;

    @Mock
    private AlbumDto response;

    @Test
    public void albumsOkTest() {
        AlbumDto response = new AlbumDto();
        doReturn(List.of(album)).when(service).getAlbums();
        doReturn(List.of(response)).when(mapper).map(anyList());
        ResponseEntity<List<AlbumDto>> actual = resource.getAlbums("traceId", "Authorization");
        verify(service, times(1)).getAlbums();
        verify(mapper, times(1)).map(anyList());
    }

}
