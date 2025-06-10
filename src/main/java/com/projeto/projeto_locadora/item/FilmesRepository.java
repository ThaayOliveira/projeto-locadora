package com.projeto.projeto_locadora.item;

import com.projeto.projeto_locadora.item.Status.ItemStatus;
import com.projeto.projeto_locadora.item.Status.TipoItem;
import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class FilmesRepository {

    private final ItemRepository itemRepository;

    public FilmesRepository(ItemRepository itemRepository) {
        this.itemRepository = itemRepository;
    }

    @PostConstruct
    public void carregarDados() {
        if (itemRepository.count() == 0) {
            List<Item> itens = List.of(
                criarItem("Star Wars - A vingança dos Sith", "Ficção Científica", 6.50, TipoItem.DVD, "star-wars.webp"),
                criarItem("Jogos Vorazes", "Ação", 5.00, TipoItem.BLU_RAY, "jogos-vorazes.webp"),
                criarItem("Clair Obscur: Expedition 33", "RPG", 4.90, TipoItem.JOGO, "clair-obscur.webp"),
                criarItem("John Wick 2", "Ação", 6.00, TipoItem.DVD, "john-wick.webp"),
                criarItem("A Viagem de Chihiro", "Animação", 4.50, TipoItem.DVD, "a-viagem-de-chihiro.webp"),
                criarItem("Outlast", "Terror", 4.90, TipoItem.JOGO, "outlast.webp"),
                criarItem("Spider-Man 2", "Aventura", 5.50, TipoItem.BLU_RAY, "spider-man.webp"),
                criarItem("O Rei Leão", "Animação", 4.00, TipoItem.DVD, "rei-leao.webp"),
                criarItem("Willy's Wonderland", "Terror", 4.90, TipoItem.BLU_RAY, "willy-wonderland.webp")
            );

            itemRepository.saveAll(itens);
        }
    }

    private Item criarItem(String titulo, String genero, Double preco, TipoItem tipo, String imagemUrl) {
        Item item = new Item();
        item.setTitulo(titulo);
        item.setGenero(genero);
        item.setPrecoDiario(preco);
        item.setTipo(tipo);
        item.setStatus(ItemStatus.DISPONIVEL);
        item.setImagemUrl("/assets/" + imagemUrl);
        return item;
    }
}
