package seedu.address.logic.commands;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static seedu.address.logic.commands.CommandTestUtil.assertCommandSuccess;
import static seedu.address.testutil.TypicalPersons.getTypicalAddressBook;
import static seedu.address.testutil.TypicalPersons.getTypicalRecycleBin;
import static seedu.address.ui.MainWindow.DARK_MODE;

import org.junit.Before;
import org.junit.Test;

import seedu.address.model.Model;
import seedu.address.model.ModelManager;
import seedu.address.model.UserPrefs;


public class ModeCommandTest {

    private Model model;
    private Model expectedModel;
    private UserPrefs prefs;
    private ModeCommand modeCommand;

    @Before
    public void setUp() {
        model = new ModelManager(getTypicalAddressBook(), getTypicalRecycleBin(), new UserPrefs());
        expectedModel = new ModelManager(model.getAddressBook(), model.getRecycleBin(), new UserPrefs());
        modeCommand = new ModeCommand();
        prefs = new UserPrefs();
    }

    @Test
    public void execute_mode_command() {
        assertCommandSuccess(modeCommand, model, ModeCommand.MESSAGE_SUCCESS, expectedModel);
    }

    @Test
    public void check_valid_theme() {
        assertTrue(prefs.getTheme().contains(DARK_MODE));
    }

    @Test
    public void equals() {
        //correct input -> returns true
        assertTrue(ModeCommand.COMMAND_WORD.equals("mode"));

        //case sensitive -> returns false
        assertFalse(ModeCommand.COMMAND_WORD.equals("Mode"));
    }
}
