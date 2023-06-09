package demo.microservices.messaging.patterns.claim.check.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
@Table(name = "payload")
public class PayLoad {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long payloadId;
	private String claimId;

	private String payloadString;
}
