$("button.createProduct")
		.click(
				function() {
					
					var firstName = $("form.createEmployee input.employeeFirstName").val();
					var lastName = $("form.createEmployee input.employeeLastName").val();
					var position = $("form.createEmployee input.employeePosition").val();
					var salary = $("form.createEmployee input.employeeSalary").val();
				
						var employee = {
								firstName : firstName,
								lastName : lastName,
								position : position,
								salary : salary
						};
//add validation
						$.post("employee", employee,
								function(data) {
									if (data == 'Success') {
//										
										alert('Success');
									}
								});
					
				});