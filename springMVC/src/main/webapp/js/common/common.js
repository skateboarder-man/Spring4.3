
const makeSelectBox = (id, firstOp, data) =>{
	let addOption = '';
	console.log(firstOp);
	if(firstOp!=null){
    	addOption += "<option>"+firstOp+"</option>";
  	}
  
	$.each(data ,(index, item)=>{
		addOption += "<option value='"+item.departmentId+"'>"+item.departmentName+"</option>";
	})
	
	$(id).append(addOption); 
}


const departmentSelectBox = (id, firstOp) =>{
	
	$.ajax({
		url:"/public/getDepartmentList.do"
		, contentType:"application/json; charset=utf-8"
		, type:"GET"
		, data: null
		, dataType: "json"
		, async : true
		, success: function(response){
			
			if(response.code !='200'){
				alert('MESSAGE: '+ response.msg +'ERROR_CODE: '+response.code)
				return 
			}
			
			makeSelectBox(id, firstOp, response.data);
			
		}
		, error: function(request, status, error){
			console.log(error);
			console.log(request);
		}
	})
};


const formToJson = (formArray) =>{
	var jsonObj = {};
	$.each(formArray, (index,value) => {
		jsonObj[value.name]=value.value;
	});
	return jsonObj;
}