package bankAccountApp;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BankAccountTest {

    // Happy path : dépôt normal
    @Test
    void depositMoney_withPositiveAmount_increasesBalance() {
        // Arrange
        BankAccount account = new BankAccount();
        account.depositMoney(100.0); // solde initial = 100

        // Act
        account.depositMoney(50.0);

        // Assert
        assertEquals(150.0, account.getBalance(), 0.0001);
    }

    // Edge case : dépôt négatif
    @Test
    void depositMoney_withNegativeAmount_doesNotChangeBalance() {
        BankAccount account = new BankAccount();
        account.depositMoney(100.0); // solde initial = 100

        account.depositMoney(-50.0);

        assertEquals(100.0, account.getBalance(), 0.0001);
    }

    // Happy path : retrait valide
    @Test
    void withdrawMoney_withValidAmount_decreasesBalanceAndReturnsTrue() {
        BankAccount account = new BankAccount();
        account.depositMoney(200.0);   // solde = 200
        account.setWithdrawLimit(500.0); // limite suffisamment grande

        boolean success = account.withdrawMoney(100.0);

        assertTrue(success);
        assertEquals(100.0, account.getBalance(), 0.0001);
    }

    // Edge case : retrait supérieur au solde ou à la limite
    @Test
    void withdrawMoney_exceedingBalanceOrLimit_returnsFalseAndKeepsBalance() {
        BankAccount account = new BankAccount();
        account.depositMoney(100.0);   // solde = 100
        account.setWithdrawLimit(50.0); // limite = 50

        // 1) Montant supérieur au solde
        boolean successTooMuch = account.withdrawMoney(200.0);
        assertFalse(successTooMuch);
        assertEquals(100.0, account.getBalance(), 0.0001);

        // 2) Montant supérieur au withdrawLimit
        boolean successAboveLimit = account.withdrawMoney(60.0);
        assertFalse(successAboveLimit);
        assertEquals(100.0, account.getBalance(), 0.0001);
    }
}
