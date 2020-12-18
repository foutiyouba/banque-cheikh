package org.sid;
import java.util.Date;

import org.sid.dao.ClientRepository;
import org.sid.dao.CompteRepository;
import org.sid.dao.OperationRepository;
import org.sid.entities.Client;
import org.sid.entities.Compte;
import org.sid.entities.CompteCourant;
import org.sid.entities.CompteEpargne;
import org.sid.entities.Operation;
import org.sid.entities.Retrait;
import org.sid.entities.Versement;
import org.sid.metier.IBanque;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javassist.expr.NewArray;

@SpringBootApplication
public class BanqueApplication implements CommandLineRunner {
     @Autowired
	private ClientRepository clientRepository;
    @Autowired
     private CompteRepository compteRepository;
    @Autowired
    private OperationRepository operationRepository;   
    @Autowired
    private IBanque banquei;
    
	public static void main(String[] args) {
        SpringApplication.run(BanqueApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
	/*	
	Client c1=clientRepository.save(new Client("cheikh", "foutiyou93@gmail.com"));
	Client c2=clientRepository.save(new Client("zik", "tabac@gmail.com"));
	
	Compte cp1=compteRepository.save(
			new CompteCourant("cp1", new Date(), 9000, c1, 6000));
	Compte cp2=compteRepository.save(
			new CompteCourant("cp2", new Date(), 12200, c2, 5.5));

    operationRepository.save(new Versement(new Date(), 9000, cp1));
    operationRepository.save(new Versement(new Date(), 12000, cp1));
    operationRepository.save(new Versement(new Date(), 1000, cp1));
    operationRepository.save(new Retrait(new Date(), 90000, cp1));
    
    operationRepository.save(new Versement(new Date(), 2000, cp2));
    operationRepository.save(new Versement(new Date(), 3200, cp2));
    operationRepository.save(new Versement(new Date(), 3000, cp2));
    operationRepository.save(new Retrait(new Date(),3300, cp2));
    
     banquei.verser("cp1",111111);
    */
	}

}
