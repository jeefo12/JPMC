package Components;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Alexandru Dochioiu
 * Date : 21/10/17
 */


public class Entity {
    /**
     * Constructor
     * @param entityName the name of the entity
     */
    public Entity(String entityName) {
        if (entityName == null) {
            throw new IllegalArgumentException("entityName");
        }

        this.name = entityName;
    }

    /**
     * Adds a transaction to the entity
     * @param transaction the transaction to be added to this entity
     * @return true if the transaction was successfully added; false otherwise
     */
    public boolean addTransaction(
            ITransaction transaction
    ) {
        try {
            transactions.add(transaction);
            return true;
        }
        catch (Exception e) {
            return false;
        }
    }

    /**
     * Getter used for obtaining the name of the entity
     * @return the entity name
     */
    public String getName() {
        return name;
    }

    /**
     * Computes the cashflow generated by this entity in either direction
     * @param direction the desired direction of the cashflow
     * @return the amount in US Dollars of cashflow generated in the requested direction
     */
    public double getTotalDirectedCashflow(Transaction.CashflowDirection direction) {
        double amount = 0;
        for (ITransaction t : transactions) {
            if (t.getCashflowDirection() == direction) {
                amount += t.getUsdValue();
            }
        }
        return amount;
    }

    private List<ITransaction> transactions = new ArrayList<>();
    private String name;
}