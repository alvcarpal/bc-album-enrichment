-- Album table creation
CREATE TABLE IF NOT EXISTS album (
    id             INT PRIMARY KEY,
    user_id        INT NOT NULL,
    title          VARCHAR(255),
    version        INTEGER,
    created_by     VARCHAR(80) NOT NULL DEFAULT '',
    updated_by     VARCHAR(80) NOT NULL DEFAULT ''
);

-- Album comments and settings
CREATE INDEX IF NOT EXISTS album_user_id_idx ON album (user_id);

-- Photo table creation
CREATE TABLE IF NOT EXISTS photo (
    id                INT PRIMARY KEY,
    album_id          INT NOT NULL,
    title             VARCHAR(255),
    url               VARCHAR(255),
    thumbnail_url     VARCHAR(255),
    created_by        VARCHAR(80) NOT NULL DEFAULT '',
    updated_by        VARCHAR(80) NOT NULL DEFAULT '',
    CONSTRAINT fk_album FOREIGN KEY (album_id) REFERENCES album(id)
);

-- Photo comments and settings
CREATE INDEX IF NOT EXISTS album_id_idx ON photo (album_id);

