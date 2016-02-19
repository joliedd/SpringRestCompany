// The root URL for the RESTful services
var rootURL = "http://localhost:8080/SpringRestCompany/rest";

var count=1;


// Retrieve Company list when application starts 
findAll();

// Nothing to delete in initial application state
$('#btnDelete:button').hide();

// Register listeners
$('#btnSearch:button').click(function() {
	search($('#searchKey').val());
	return false;
});

// Trigger search when pressing 'Return' on search key input field
$('#searchKey').keypress(function(e){
	if(e.which == 13) {
		search($('#searchKey').val());
		e.preventDefault();
		return false;
    }
});

$('#btnAdd:button').click(function() {
	
	newCompany();
	return false;
});

$('#btnSave:button').click(function() {
	if ($('#companyId').val() == '')
		
		addCompany();
	 
	else
		updateCompany();
	return false;
});

$('#btnDelete:button').click(function() {
	deleteCompany();
	return false;
});

$('#companyList a').live('click', function() {
	findById($(this).data('identity'));
});


function search(searchKey) {
	if (searchKey == '') 
		findAll();
	else
		findByName(searchKey);
}

function newCompany() {
	alert('newCompany!!');
	
	$('#btnDelete:button').hide();
	
	currentCompany = {};
	renderDetails(currentCompany); // Display empty form
}

function findAll() {
	console.log('findAll');
	$.ajax({
		type: 'GET' ,
		url: rootURL + '/' + "comps",
		dataType: "json", // data type of response
		success: renderList
	});
}


function findById(id) {
	console.log('findById: ' + id);
	$.ajax({
		type: 'GET',
		url: rootURL + '/comp/' + id,
		dataType: "json",
		success: function(data){
			$('#btnDelete:button').show();
			console.log('findById success: ' + data.name);
			currentCompany = data;
			renderDetails(currentCompany);
		}
	});
}

function addCompany() {
	
	
	var JSONObject=formToJSON();
	console.log('addCompany');
	console.log('count'+count);
	$.ajax({
		type: 'POST',
		contentType: "application/json; charset=utf-8",
		url: rootURL + '/comp/create' ,
		dataType: "json",
		cache: true,
		data: formToJSON(),//JSON.stringify(JSONObject),//
	}).done(function(data) {
		   
			alert('Company created successfully');
			$('#btnDelete:button').show();
			$('#companyId').val(data.id);
		}).fail(console.log("failed"));
		
}

function updateCompany() {
	console.log('updateCompany');
	$.ajax({
		type: 'PUT',
		contentType: 'application/json',
		url: rootURL + '/comp/update/' + $('#companyId').val(),
		dataType: "json",
		data: formToJSON(),
		success: function(data, textStatus, jqXHR){
			alert('Company updated successfully');
		},
		error: function(jqXHR, textStatus, errorThrown){
			alert('updateCompany error: ' + textStatus);
		}
	});
}

function deleteCompany() {
	console.log('deleteCompany');
	$.ajax({
		type: 'DELETE',
		url: rootURL +  '/comp/delete/'  + $('#companyId').val(),
		success: function(data, textStatus, jqXHR){
			alert('Company deleted successfully');
		},
		error: function(jqXHR, textStatus, errorThrown){
			alert('deleteCompany error');
		}
	});
}

function renderList(data) {
	// JAX-RS serializes an empty list as null, and a 'collection of one' as an object (not an 'array of one')
	var list = data == null ? [] : (data instanceof Array ? data : [data]);

	$('#companyList li').remove();
	$.each(list, function(index, Company) {
		$('#companyList').append('<li><a href="'+rootURL+'/comp/' + Company.id + '" data-identity="' + Company.id + '">'+Company.name+'</a></li>');
	});
}

function renderDetails(Company) {
	
		$('#companyId').val(Company.id);
	
	$('#name').val(Company.name);
	$('#address').val(Company.address);
	$('#city').val(Company.city);
	$('#country').val(Company.country);
	$('#email').val(Company.email);
	$('#phone').val(Company.phone);
	$('#owners').val(Company.description);
}

// Helper function to serialize all the form fields into a JSON string
function formToJSON() {
	var companyId = $('#companyId').val();
	
	if (companyId == "")  count=count+1;
	
	
	return JSON.stringify({
		"id": companyId == "" ? count : companyId, 
		"name": $('#name').val(), 
		"address": $('#address').val(),
		"city": $('#city').val(),
		"country": $('#country').val(),
		"email": $('#email').val(),
		"phone": $('#phone').val(),
		"owners": $('#owners').val()
		});
	 
	
	 
}
