/**
 * 
 */
function postJson() {
	$.ajax({
		url : $("#urlSelect").val(),
		type : "POST",
		contentType : 'application/json;charset=UTF-8',
		data : $("#postValue").val(),
		success : function(data) {
			alert(JSON.stringify(data));
		},
		error : function(e) {
			alert("error:"+e.status+e.responseText);
		}
	})
}

function chooseJson() {
	var urlBase = $(location).attr("host")+"/cmsbackend/";
	if ($("#urlSelect").val() == "website/save") {
		$("#postValue").val('{"name":"","baseUrl":"","status":true}');
	}else if ($("#urlSelect").val() == "website/update") {
		$("#postValue").val('{"id":1,"name":"","baseUrl":"","status":true}');
	}else if ($("#urlSelect").val() == "website/updateStatus") {
		$("#postValue").val('{"id":1,"status":true}');
	}else if ($("#urlSelect").val() == "website/delete") {
		$("#postValue").val('{"id":1}');
	}else if ($("#urlSelect").val() == "page/save") {
		$("#postValue").val('{"name":"","websiteId":1,"templateId":1,"status":true,"parentPageId":null}');
	}else if ($("#urlSelect").val() == "page/update") {
		$("#postValue").val('{"id":1,"name":"","templateId":1,"status":true,"parentPageId":null}');
	}else if ($("#urlSelect").val() == "page/updateStatus") {
		$("#postValue").val('{"id":1,"status":true}');
	}else if ($("#urlSelect").val() == "page/delete") {
		$("#postValue").val('{"id":1}');
	}else if ($("#urlSelect").val() == "page/saveContent") {
		$("#postValue").val('{"pageId":1,"langId":1,"content":[{"elementId":1,"content":[{"txt1":"","txt2":""},{"txt1":"","txt2":""}]}]}');
	}else if ($("#urlSelect").val() == "pagetemplate/save") {
		$("#postValue").val('{"name":"","websiteId":1,"template":""}');
	}else if ($("#urlSelect").val() == "pagetemplate/update") {
		$("#postValue").val('{"id":1,"name":"","template":""}');
	}else if ($("#urlSelect").val() == "pagetemplate/delete") {
		$("#postValue").val('{"id":1}');
	}else if ($("#urlSelect").val() == "element/save") {
		$("#postValue").val('{"name":"","websiteId":1,"template":1}');
	}else if ($("#urlSelect").val() == "element/update") {
		$("#postValue").val('{"id":1,"name":"","template":1}');
	}else if ($("#urlSelect").val() == "element/saveb") {
		$("#postValue").val('{"name":"","websiteId":1,"template":""}');
	}else if ($("#urlSelect").val() == "element/updateb") {
		$("#postValue").val('{"id":1,"name":"","template":""}');
	}else if ($("#urlSelect").val() == "element/delete") {
		$("#postValue").val('{"id":1}');
	}
	
	$("#urlLebel").val(urlBase+$("#urlSelect").val());
}

function getJson() {
	$.ajax({
		url : $("#urlSelect1").val()+"?"+$("#param").val(),
		type : "GET",
		success : function(data) {
			$("#result").val(JSON.stringify(data))
		},
		error : function(e) {
			alert("error:"+e.status+e.responseText);
		}
	})
}

function chooseJson1() {
	var urlBase = $(location).attr("host")+"/cmsbackend/";
	var str = $("#urlSelect1").val();
	if (str == "website/single"||str == "page/single"||str == "pagetemplate/single"||str == "element/single") {
		$("#param").val('id=1');
	}else if (str == "page/"||str == "pagetemplate/"||str == "element/") {
		$("#param").val('websiteId=1');
	}else if (str == "page/parsePage"||str == "page/getContent") {
		$("#param").val('id=1&langId=1');
	}
	$("#urlLebel1").val(urlBase+str);
}

