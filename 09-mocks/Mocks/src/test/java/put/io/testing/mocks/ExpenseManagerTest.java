package put.io.testing.mocks;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import java.net.ConnectException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.mockito.invocation.InvocationOnMock;
import org.mockito.stubbing.Answer;

import java.util.Arrays;
import put.io.students.fancylibrary.service.FancyService;

public class ExpenseManagerTest {

    @Test
    void testCalculateTotal() {
        ExpenseRepository rep = mock(ExpenseRepository.class);
        FancyService fancy = new FancyService();
        ExpenseManager manager = new ExpenseManager(rep, fancy);

        Expense expense1 = new Expense();
        expense1.setAmount(4);
        Expense expense2 = new Expense();
        expense2.setAmount(2);
        Expense expense3 = new Expense();
        expense3.setAmount(2);
        List<Expense> exp = new ArrayList<Expense>();
        exp.add(expense1);
        exp.add(expense2);
        exp.add(expense3);

        when(rep.getExpenses()).thenReturn(exp);
        assertEquals(8, manager.calculateTotal());
    }

    @Test
    void testCalculateTotalForCategory() {
        ExpenseRepository rep = mock(ExpenseRepository.class);
        FancyService fancy = new FancyService();
        ExpenseManager manager = new ExpenseManager(rep, fancy);

        Expense expense = new Expense();
        expense.setAmount(4);
        List<Expense> exp = new ArrayList<Expense>();
        exp.add(expense);

        // pytanie 5.1: kolejność ma znaczenie
        when(rep.getExpensesByCategory(anyString())).thenReturn(Collections.emptyList());
        when(rep.getExpensesByCategory("Home")).thenReturn(exp);
        when(rep.getExpensesByCategory("Car")).thenReturn(exp);


        assertEquals(0, manager.calculateTotalForCategory("Food"));
        assertEquals(0, manager.calculateTotalForCategory("Sport"));
        assertEquals(4, manager.calculateTotalForCategory("Home"));
        assertEquals(4, manager.calculateTotalForCategory("Car"));


    }



    @Test
    void testCalculateTotalInDollars() throws ConnectException {

        ExpenseRepository rep = mock(ExpenseRepository.class);
        FancyService fancy = mock(FancyService.class);
        ExpenseManager manager = new ExpenseManager(rep, fancy);

        Expense expense = new Expense();
        expense.setAmount(4);
        List<Expense> exp = new ArrayList<Expense>();
        exp.add(expense);
        when(rep.getExpenses()).thenReturn(exp);


        when(fancy.convert(anyDouble(),eq("PLN"),eq("USD"))).thenAnswer(new Answer(){
            public Object answer(InvocationOnMock onMock){
                return Double.parseDouble(onMock.getArguments()[0].toString())*0.25;
            }

        });
        assertEquals(1,manager.calculateTotalInDollars());

    }


}
