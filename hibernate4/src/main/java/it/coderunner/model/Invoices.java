package it.coderunner.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Invoices")
public class Invoices {
	
		@Id
		@Column(name = "id")
		@GeneratedValue(strategy = GenerationType.IDENTITY)
		private int id;
		
		@Column(name="product")
		private String product;

		@Column(name="quantity")
		private int quantity;


		public int getId() {
			return id;
		}


		public void setId(int id) {
			this.id = id;
		}


		public String getProduct() {
			return product;
		}


		public void setProduct(String product) {
			this.product = product;
		}


		public int getQuantity() {
			return quantity;
		}


		public void setQuantity(int quantity) {
			this.quantity = quantity;
		}


		@Override
		public String toString() {
			return "id=" + id + ", product=" + product + ", quantity=" + quantity;
		}
}
