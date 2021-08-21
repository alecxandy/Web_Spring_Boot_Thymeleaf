package service;

import dao.MusicaDAO;
import dao.PlayListDAO;
import domain.Musica;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class MusicaServiceImp implements MusicaService {

    @Autowired
    private MusicaDAO musicaDAO;

    @Autowired
    private PlayListDAO playListDAO;

    @Override
    public void salvar(Musica musica, long playlistId) {
        musica.setPlaylist(playListDAO.recuperarPorID(playlistId));
        musicaDAO.salvar(musica);
    }

    @Override
    @Transactional(readOnly = true)
    public List<Musica> recuperarPorPlaylist(long playlistId) {
        return musicaDAO.recuperarPorPlaylist(playlistId);
    }

    @Override
    @Transactional(readOnly = true)
    public Musica recuperarPorPlaylistIdEMusicaId(long playlistId, long musicaId) {
        return musicaDAO.recuperarPorPlaylistIdEMusicaId(playlistId, musicaId);
    }

    @Override
    public void atualizar(Musica musica, long playlistId) {
        musica.setPlaylist(playListDAO.recuperarPorID(playlistId));
        musicaDAO.atualizar(musica);
    }

    @Override
    public void excluir(long playlistId, long musicaId) {
        musicaDAO.excluir(recuperarPorPlaylistIdEMusicaId(playlistId, musicaId).getId());
    }
}
