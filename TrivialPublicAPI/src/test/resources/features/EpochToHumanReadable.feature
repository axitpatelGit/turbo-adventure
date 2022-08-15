Feature: Validating trivial public API

Scenario: Verify trivial public API returning correct current date & time value

	Given trivial public API http GET request
	When unix time is current time
	Then API call is success with status code 200
	And Datetime field present in response should be current Time
	 
Scenario: Verify trivial public API returning correct date & time for lower side boundry value 

	Given trivial public API http GET request
	When unix time is "-2147483648"
	Then API call is success with status code 200
	And "Datetime" field present in response should be "1901-12-13 20:45:52"

Scenario: Verify trivial public API returning Error message for outside lower boundry value 

	Given trivial public API http GET request
	When unix time is "-2147483649"
	Then API call is success with status code 400
	And "Error" field present in response should be "UnixTimeService.RESTHost.fromunixtimestamp.TryCatch.Try.UnixTimeStamp: Value was either too large or too small for an Int32."

Scenario: Verify trivial public API returning correct date & time for zero value 

	Given trivial public API http GET request
	When unix time is "0"
	Then API call is success with status code 200
	And "Datetime" field present in response should be "1970-01-01 00:00:00"

Scenario: Verify trivial public API returning correct date & time for higher side boundry value 

	Given trivial public API http GET request
	When unix time is "2147483647"
	Then API call is success with status code 200
	And "Datetime" field present in response should be "2038-01-19 03:14:07"

Scenario: Verify trivial public API returning Error message for outside higher boundry value 

	Given trivial public API http GET request
	When unix time is "2147483648"
	Then API call is success with status code 400
	And "Error" field present in response should be "UnixTimeService.RESTHost.fromunixtimestamp.TryCatch.Try.UnixTimeStamp: Value was either too large or too small for an Int32."
	
Scenario: Verify trivial public API returning Error message for blank value 

	Given trivial public API http GET request
	When unix time is ""
	Then API call is success with status code 400
	And "Error" field present in response should be "UnixTimeService.RESTHost.fromunixtimestamp.TryCatch.Try.UnixTimeStamp: Value cannot be null. (Parameter 's') (Parameter 's')"	
	
Scenario: Verify trivial public API returning Error message for unix time greater than 10 digits 

	Given trivial public API http GET request
	When unix time is "15498922800"
	Then API call is success with status code 400
	And "Error" field present in response should be "UnixTimeService.RESTHost.fromunixtimestamp.TryCatch.Try.UnixTimeStamp: Value was either too large or too small for an Int32."		 

Scenario: Verify trivial public API returning correct date & time for unix time less than 10 digits 

	Given trivial public API http GET request
	When unix time is "154989228"
	Then API call is success with status code 200
	And "Datetime" field present in response should be "1974-11-29 20:33:48"
	
Scenario: Verify trivial public API returning Error message for invalid string as unix time

	Given trivial public API http GET request
	When unix time is "dt15498980"
	Then API call is success with status code 400
	And "Error" field present in response should be "UnixTimeService.RESTHost.fromunixtimestamp.TryCatch.Try.UnixTimeStamp: Input string was not in a correct format."		 	