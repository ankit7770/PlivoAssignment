package Plivo.plivo.assignment.restController;

import Plivo.plivo.assignment.entity.ContactBook;
import Plivo.plivo.assignment.repo.ContactBookRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class CustomerRestController {

	// autowire the ContactBookService
	/*@Autowired
	private ContactBookService contactBookService;*/

	@Autowired
	private ContactBookRepo contactBookRepo;
	

	@GetMapping("/Plivo")
	public String testing(){
		return "Started";
	}

	// add mapping for GET /contactBooks
	@GetMapping("/contactBooks")
	public List<ContactBook> getContacts() {
		
		return contactBookRepo.findAll();
	}
	
	// add mapping for GET /contactBook/{contactBookId}
	
	@GetMapping("/contactBookById/{contactBookId}")
	public ContactBook getContactById(@PathVariable int contactBookId) {

		ContactBook contactBook = contactBookRepo.findContactBookById(contactBookId);
		
		/*if (contactBook == null) {
			throw new CustomerNotFoundException("Customer id not found - " + customerId);
		}*/
		
		return contactBook;
	}

	// add mapping for GET /contactBook/{contactBookName}

	@GetMapping("/contactBookByName/{contactBookName}")
	public List<ContactBook> getContactByName(@PathVariable String contactBookName) {

		List<ContactBook> contactBook = contactBookRepo.findContactBookByName(contactBookName);

		/*if (contactBook == null) {
			throw new CustomerNotFoundException("Customer id not found - " + customerId);
		}*/

		return contactBook;
	}

	// add mapping for GET /contactBook/{contactBookName}

	@GetMapping("/contactBookByEmail/{contactBookEmail}")
	public ContactBook getContactByEmail(@PathVariable String contactBookEmail) {

		ContactBook contactBook = contactBookRepo.findContactBookByEmail(contactBookEmail);

		/*if (contactBook == null) {
			throw new CustomerNotFoundException("Customer id not found - " + customerId);
		}*/

		return contactBook;
	}

	// add mapping for POST /contactBook  - add new contactBook
	
	@PostMapping("/contactBook")
	public void addContact(@RequestBody ContactBook contactBook) {
		
		// also just in case the pass an id in JSON ... set id to 0
		// this is force a save of new item ... instead of update
		
		contactBook.setId(0);

		contactBookRepo.save(contactBook);

	}

	// add mapping for PUT /customers - update existing customer

	@PutMapping("/contactBook")
	public ContactBook updateContact(@RequestBody ContactBook contactBook) {

		contactBookRepo.save(contactBook);

		return contactBook;

	}

	// add mapping for DELETE /contactBook/{customerId} - delete contactBook

	@DeleteMapping("/contactBook/{contactBookId}")
	public String deleteContact(@PathVariable int contactBookId) {

		ContactBook tempContactBook = contactBookRepo.findContactBookById(contactBookId);

		// throw exception if null

		/*if (tempCustomer == null) {
			throw new CustomerNotFoundException("Customer id not found - " + customerId);
		}*/

		contactBookRepo.delete(tempContactBook);

		return "Deleted contact id - " + contactBookId;
	}
}