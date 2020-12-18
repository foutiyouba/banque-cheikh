package org.sid.metier;

import org.sid.entities.Compte;


public interface IBanque {
	public Compte consulterCompte(String cpte);
    public void verser(String cpte, double mtn);
    public void retirer(String cpte, double mtn);
    public void virement(String cpte1, String cpte2, double mtn);
   // public Page<Operation> listeOperation(String cpte1, int page, int size);
}