package dao;

import domain.Musica;

import java.util.List;

// Programar para interface ao inves de programar para implementação uma recomendação da programação orientada a objeto
// dessa forma nosso codigo se torna menos independente de uma aplicação
public interface MusicaDAO {

    void salvar(Musica musica);

    List<Musica> recuperarPorPlaylist(long playlistId);

    Musica recuperarPorPlaylistIdEMusicaId(long playlistId, long musicaId);

    void atualizar(Musica musica);

    void excluir(long musicaId);
}
