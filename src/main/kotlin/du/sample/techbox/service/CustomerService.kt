package du.sample.techbox.service

import du.sample.techbox.dto.Customer

class CustomerService {

    val customerStub = Customer(
        "1",
        "John Smith",
        21,
        "Student")

    fun getCustomerById(customerID: String) =
        if (customerID == customerStub.id)
                customerStub
        else Customer(null, null, null, null)
}