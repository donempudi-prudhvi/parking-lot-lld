package interfaces;

import models.Ticket;

public interface FareCalculationStrategyInterface {

    public double getFare(Ticket ticket);
} 