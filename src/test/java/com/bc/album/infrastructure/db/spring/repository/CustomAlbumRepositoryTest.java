package com.bc.album.infrastructure.db.spring.repository;

import com.bc.album.domain.operational.Album;
import com.bc.album.infrastructure.db.springdata.mapper.AlbumsDboMapper;
import com.bc.album.infrastructure.db.springdata.model.AlbumDbo;
import com.bc.album.infrastructure.db.springdata.repository.CustomAlbumRepository;
import com.bc.album.infrastructure.db.springdata.repository.jpa.JpaAlbumRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import java.util.List;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.anyList;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

@RunWith(MockitoJUnitRunner.class)
public class CustomAlbumRepositoryTest {

    @Mock
    private JpaAlbumRepository mockJpaAlbumRepository;

    @Mock
    private AlbumsDboMapper mockAlbumsDboMapper;

    @InjectMocks
    private CustomAlbumRepository customAlbumRepository;

    @Mock
    private AlbumDbo albumDbo;

    @Mock
    private Album album;

    @Test
    public void testGetAlbums() {
        Mockito.doReturn(List.of(albumDbo)).when(mockJpaAlbumRepository).retrieveAll();
        Mockito.doReturn(List.of(album)).when(mockAlbumsDboMapper).map(anyList());
        List<Album> actualAlbumList = customAlbumRepository.getAlbums();
        assertEquals(List.of(album), actualAlbumList);
        verify(mockJpaAlbumRepository, times(1)).retrieveAll();
        verify(mockAlbumsDboMapper, times(1)).map(anyList());
    }

}
