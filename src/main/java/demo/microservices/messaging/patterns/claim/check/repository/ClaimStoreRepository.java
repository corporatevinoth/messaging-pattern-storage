package demo.microservices.messaging.patterns.claim.check.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import demo.microservices.messaging.patterns.claim.check.entity.ClaimStore;
import demo.microservices.messaging.patterns.claim.check.entity.PayLoad;

@Repository
public interface ClaimStoreRepository extends JpaRepository<ClaimStore,Long> {

	ClaimStore findByClaimId(String claimId);


 }
