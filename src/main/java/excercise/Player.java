package excercise;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.*;

public class Player {
    private String name;
    private int id;
    private List<String> games;

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setGames(List<String> games) {
        this.games = games;
    }

    public List<String> getGames() {
        return games;
    }

    @Override
    public String toString() {
        return "Player{" +
                "name='" + name + '\'' +
                ", id=" + id +
                ", games=" + games +
                '}';
    }

    public static void main(String[] args) throws JsonProcessingException {
        String jsonString   = "[{\"name\":\"player1\",\"id\":76,\"games\":[\"football\",\"cricket\"]},{\"name\":\"player2\",\"id\":4624,\"games\":[\"basketBall\",\"cricket\"]}]";

        ObjectMapper mapper = new ObjectMapper();

        Player[] players = mapper.readValue(jsonString, Player[].class);

        //Map<String, List<Player>> gamePlay = new HashMap<>();

//        for(Player player: players){
//            for(String name: player.getGames()){
//                gamePlay.computeIfAbsent(name, k -> new ArrayList<>()).add(player);
//            }
//        }
        Map<String, List<Player>> gamePlayerMap = Arrays.stream(players)
                .flatMap(player -> player.getGames().stream().map(game -> new AbstractMap.SimpleEntry<>(game, player)))
                .collect(
                        HashMap::new, // Supplier: Create a new HashMap
                        (map, entry) -> map.computeIfAbsent(entry.getKey(), k -> new ArrayList<>()).add(entry.getValue()), // Accumulator: Add player to the list of players for the game
                        HashMap::putAll // Combiner: Combine the results of different threads (not needed here as we're using a single thread)
                );

        gamePlayerMap.forEach((game, playerlist) -> {
            System.out.println(game + " : " + playerlist);
        });
    }
}

