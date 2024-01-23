package com.bc.album.infrastructure.rest.spring.mapper;

import com.bc.album.domain.operational.Album;
import com.bc.album.infrastructure.rest.spring.dto.AlbumDto;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import java.util.List;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class AlbumsMapperTest {

    @Mock
    Album album;

    @Mock
    AlbumDto albumDto;

    @Mock
    private AlbumsMapper albumsMapper;

    @Test
    public void testMapAlbum() {
        when(albumsMapper.map(album)).thenReturn(albumDto);
        AlbumDto actualDto = albumsMapper.map(album);
        assertEquals(albumDto, actualDto);
    }

    @Test
    public void testMapAlbumList() {
        when(albumsMapper.map(List.of(album))).thenReturn(List.of(albumDto));
        List<AlbumDto> actualDtoList = albumsMapper.map(List.of(album));
        assertEquals(List.of(albumDto), actualDtoList);
    }

}
