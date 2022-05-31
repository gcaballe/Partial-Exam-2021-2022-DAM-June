package dam.gtidic.examenfinal2122.usecases.game.level;
import dam.gtidic.examenfinal2122.usecases.models.Level;

public interface LevelRepository {

    // Return a level identified by id
    public Level getLevel(int id);

    // Return the number of questions to pass the level
    public int getSize();

}
