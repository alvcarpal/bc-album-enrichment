package com.bc.album.infrastructure.db.springdata.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;

/**
 * Album PK
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Embeddable
public class AlbumPk implements Serializable {

    /**
     * serialVersionUID.
     */
    private static final long serialVersionUID = 1L;

    @Column(name = "id")
    private Integer id;

}
