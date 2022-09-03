package com.example.turbinecancelhangs.ui

import app.cash.molecule.RecompositionClock
import app.cash.molecule.launchMolecule
import app.cash.turbine.test
import junit.framework.TestCase.assertEquals
import kotlinx.coroutines.CancellationException
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.cancel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.runBlocking
import org.junit.Test

class MoleculePresenterTest {
  @Test
  fun test() = runBlocking {
    makePresenter().test {
      assertEquals(Model("Hello!"), awaitItem())
      cancelAndIgnoreRemainingEvents()
    }
  }

  private fun CoroutineScope.makePresenter(): StateFlow<Model> {
    return launchMolecule(RecompositionClock.Immediate) {
      MoleculePresenter()
    }
  }
}
