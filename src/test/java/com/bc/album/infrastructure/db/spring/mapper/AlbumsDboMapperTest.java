package com.bc.album.infrastructure.db.spring.mapper;

import com.bc.album.domain.operational.Album;
import com.bc.album.infrastructure.db.springdata.mapper.AlbumsDboMapper;
import com.bc.album.infrastructure.db.springdata.model.AlbumDbo;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import java.util.List;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class AlbumsDboMapperTest {

    @Mock
    Album album;

    @Mock
    AlbumDbo albumDbo;

    @Mock
    private AlbumsDboMapper mapper;

    @Test
    public void testMapAlbum() {
        when(mapper.map(albumDbo)).thenReturn(album);
        Album actual = mapper.map(albumDbo);
        assertEquals(album, actual);
    }

    @Test
    public void testMapAlbumList() {
        when(mapper.map(List.of(albumDbo))).thenReturn(List.of(album));
        List<Album> actualList = mapper.map(List.of(albumDbo));
        assertEquals(List.of(album), actualList);
    }

}
