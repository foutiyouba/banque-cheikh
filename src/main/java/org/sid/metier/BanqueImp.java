package org.sid.metier;

import java.util.Date;

import org.sid.dao.CompteRepository;
import org.sid.dao.OperationRepository;
import org.sid.entities.Compte;
import org.sid.entities.CompteCourant;
import org.sid.entities.Retrait;
import org.sid.entities.Versement;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
class BanqueImp implements IBanque{

	@Autowired
	private CompteRepository compteRepository;
	@Autowired
	private OperationRepository operationRepository;
	@Override
	public Compte consulterCompte(String cpte) {
		// TODO Auto-generated method stub
	
		Compte cp=compteRepository.findById(cpte).orElse(null);
		        
		if (cp==null) throw new RuntimeException("compte introvable");
		return cp;
	}

	@Override
	public void verser(String cpte, double mtn) {
		// TODO Auto-generated method stub
		Compte cp=consulterCompte(cpte);
		Versement v= new Versement(new Date(), mtn, cp);
		operationRepository.save(v);
		cp.setSolde(cp.getSolde()+mtn);
		compteRepository.save(cp);
		
		
	}

	@Override
	public void retirer(String cpte, double mtn) {
		// TODO Auto-generated method stub
		Compte cp=consulterCompte(cpte);
		double fc=0;
		
		if (cp instanceof CompteCourant) 
			fc=((CompteCourant) cp).getDecouvert();
		
		if (cp.getSolde()+fc < mtn)  throw new RuntimeException("retrait impossible");
		Retrait r=new Retrait(new Date(), mtn, cp);
		operationRepository.save(r);	
		cp.setSolde(cp.getSolde()-mtn);
		compteRepository.save(cp);
	
		}

	@Override
	public void virement(String cpte1, String cpte2, double mtn) {
		// TODO Auto-generated method stub
	 
		if(cpte1.equals(cpte2)) throw new RuntimeException("virement vers un meme compte");
		retirer(cpte1, mtn);
		verser(cpte2, mtn);
		
	}
/*
	@Override
	public Page<Operation> listeOperation(String cpte1, int page, int size) {
		// TODO Auto-generated method stub
		//return operationRepository.listeOperation(cpte1,new PageRequest.of(page,size));
		return null;
	}
*/	
	
}