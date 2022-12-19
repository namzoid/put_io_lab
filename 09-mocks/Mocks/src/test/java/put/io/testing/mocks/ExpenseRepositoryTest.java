package put.io.testing.mocks;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import java.util.Collections;

import org.junit.jupiter.api.Test;
import org.mockito.InOrder;

import put.io.students.fancylibrary.database.FancyDatabase;
import put.io.students.fancylibrary.database.IFancyDatabase;


public class ExpenseRepositoryTest {

    @Test
    void testLoadExpenses() {
        ExpenseRepository rep = new ExpenseRepository(new MyDatabase());
        rep.loadExpenses();
        assertEquals(Collections.emptyList(),rep.getExpenses());
    }


    @Test
    void testLoadExpenses_2() {
        IFancyDatabase mockObject = mock(IFancyDatabase.class);
        when(mockObject.queryAll()).thenReturn(Collections.emptyList());

        ExpenseRepository rep = new ExpenseRepository(mockObject);
        rep.loadExpenses();

        InOrder inOrder = inOrder(mockObject);
        inOrder.verify(mockObject).connect();
        inOrder.verify(mockObject).queryAll();
        inOrder.verify(mockObject).close();

        assertEquals(Collections.emptyList(), rep.getExpenses());
    }

    @Test
    void testSaveExpenses() {
        IFancyDatabase mockObject = mock(IFancyDatabase.class);
        when(mockObject.queryAll()).thenReturn(Collections.emptyList());

        ExpenseRepository rep = new ExpenseRepository(mockObject);


        rep.addExpense(new Expense());
        rep.addExpense(new Expense());
        rep.addExpense(new Expense());
        rep.addExpense(new Expense());
        rep.addExpense(new Expense());
        rep.saveExpenses();

        verify(mockObject, times(5)).persist(any(Expense.class));

        assertFalse(rep.getExpenses().isEmpty());
    }

}
