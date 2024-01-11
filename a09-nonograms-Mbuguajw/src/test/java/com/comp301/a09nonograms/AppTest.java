package com.comp301.a09nonograms;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import com.comp301.a09nonograms.controller.Controller;
import com.comp301.a09nonograms.model.Model;
import com.comp301.a09nonograms.model.ModelImpl;
import org.junit.Test;

/** Unit test for simple App. */
public class AppTest {
  /** Rigorous Test :-) */
  @Test
  public void shouldAnswerWithTrue() {
    Model testGame = new ModelImpl(new PuzzleLibrary().create());
    testGame.setPuzzleIndex(1);
    testGame.toggleCellEliminated(2, 2);
    testGame.toggleCellShaded(1, 1);
    assertTrue(!testGame.isSolved());
  }

  @Test
  public void letsFixTheseGradeScopeErrors() {
    Model testGame = new ModelImpl(new PuzzleLibrary().create());
    testGame.setPuzzleIndex(1);
    testGame.toggleCellEliminated(2, 2);
    testGame.toggleCellShaded(1, 1);
    testGame.toggleCellEliminated(3, 3);
    testGame.toggleCellShaded(4, 4);
    assertTrue(testGame.isShaded(1, 1));
    assertTrue(testGame.isShaded(4, 4));
    assertTrue(testGame.isEliminated(2, 2));
    assertTrue(testGame.isEliminated(3, 3));
    assertFalse(testGame.isEliminated(4, 4));
    assertFalse(testGame.isEliminated(1, 1));
    assertFalse(testGame.isShaded(2, 2));
    testGame.toggleCellShaded(3, 3);
    assertFalse(testGame.isEliminated(3, 3));
    assertTrue(testGame.isShaded(3, 3));
  }
}
