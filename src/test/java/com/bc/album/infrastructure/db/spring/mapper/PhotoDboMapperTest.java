package com.bc.album.infrastructure.db.spring.mapper;

import com.bc.album.domain.operational.Photo;
import com.bc.album.infrastructure.db.springdata.mapper.PhotoDboMapper;
import com.bc.album.infrastructure.db.springdata.model.PhotoDbo;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class PhotoDboMapperTest {

    @Mock
    Photo photo;

    @Mock
    PhotoDbo photoDbo;

    @Mock
    private PhotoDboMapper mapper;

    @Test
    public void testMapAlbum() {
        when(mapper.map(photoDbo)).thenReturn(photo);
        Photo actual = mapper.map(photoDbo);
        assertEquals(photo, actual);
    }

}
