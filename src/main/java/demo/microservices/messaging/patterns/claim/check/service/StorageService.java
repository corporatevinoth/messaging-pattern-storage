package demo.microservices.messaging.patterns.claim.check.service;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import demo.microservices.messaging.patterns.claim.check.entity.ClaimStore;
import demo.microservices.messaging.patterns.claim.check.entity.PayLoad;
import demo.microservices.messaging.patterns.claim.check.repository.ClaimStoreRepository;
import demo.microservices.messaging.patterns.claim.check.repository.PayLoadRepository;

@Service
public class StorageService {
	private static Long payloadId = 1L;
	
	 @Autowired
	    private PayLoadRepository payLoadRepository;
	 
	 @Autowired
	    private ClaimStoreRepository claimStoreRepository;
	private Map<Long, String> payloadDataStore = new HashMap<>();
	private Map<String, Long> claimDataStore = new HashMap<>();
	
	public String save(String payload) {
		
		PayLoad payloadObj = new PayLoad();
		String claimId = UUID.randomUUID().toString();
		payloadObj.setClaimId(claimId);
		payloadObj.setPayloadString(payload);
		payLoadRepository.save(payloadObj);
		
		ClaimStore claimStore = new ClaimStore();
		claimStore.setClaimId(claimId);	
		claimStore.setPayLoadId(payloadId);
		claimStoreRepository.save(claimStore);
		payloadId++;
		
		return claimId;
	}
	
	public String retrieve(String claimId) {
		Long payLoadId = (claimStoreRepository.findByClaimId(claimId)).getPayLoadId();
		String payloadChunk = payLoadRepository.findByPayLoadId(payLoadId).getPayloadString();		
		return payloadChunk;
	}
	
}
