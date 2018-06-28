<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" href="css/amazeui.css" />

<link rel="stylesheet" href="css/app.css">
<link rel="stylesheet" href="css/amazeui.datatables.css">

<script src="js/jquery.min.js"></script>
<script src="js/amazeui.min.js"></script>
<script src="js/util.js"></script>
<script src="js/jquery-form.js"></script>

<script src="js/amazeui.datatables.js"></script>
<script src="js/dataTables.responsive.min.js"></script>
<script src="js/app.js"></script>
<script src="js/confirm.js"></script>

<title>用户</title>
</head>
<body>
	<div class="am-cf admin-main">
		<div class="admin-content">
			<div class="am-u-sm-12">
				<div class="am-panel am-panel-default">
					<div class="am-panel-hd"
						style="background-color: #1bbc9b; color: white;">

						<h4 class="am-panel-title"
							data-am-collapse="{parent: '#accordion', target: '#panel-1'}">
							用户管理</h4>
					</div>
					<div id="panel-1" class="am-panel-collapse am-collapse am-in">
						<div class="am-panel-bd">
							<div class="am-u-sm-12 am-u-md-12 am-u-lg-7" style="float: left">
								<div class="am-btn-toolbar">
									<div class="am-btn-group am-btn-group-xs">
										<button type="button" id="addBtn"
											class="am-btn am-btn-default am-btn-success"
											data-am-modal="{target: '#my-popup'}">
											<span class="am-icon-plus"></span> 新增
										</button>
									</div>
								</div>
							</div>


							<hr style="border: none; height: 1px; backgroud-color: #fff">

							<table id="useTable"
								class="am-table am-table-striped am-table-bordered am-table-compact am-text-nowrap dataTable dtr-inline "
								cellspacing="0" width="100%" style="font-size: 14px">
								<thead>
									<tr>
									    <td>ID</td>
										<td>用户名</td>
										<td>密码</td>
										<td>年龄</td>
										<td>性别</td>
										<td>地址</td>
										<td>操作</td>
									</tr>
								</thead>
							</table>
						</div>
					</div>
					
					
				<!-- 弹窗 -->
				<div class="am-popup" id="my-popup"
					style="display: block;">
					<div class="am-popup-inner">
						<div class="am-popup-hd">
							<h4 id="popup-title" class="am-popup-title">用户</h4>
							<span data-am-modal-close class="am-close">&times;</span>
						</div>
						<div class="am-popup-bd">
							<div style="backgroun-color:whight;">
							   <form action="" class="am-form" id="UseType">
								  <fieldset>
								   <div id="divicecode-box-id" class="am-form-group">
								      <lable for="doc-vld-name-2" >用户名：</lable>
								      <input type="text" id="userName" name="userName" required/>
								    </div>
								    <div class="am-form-group">
								      <lable for="doc-vld-name-2" >密码：</lable>
								      <input type="text" id="password" name="password"  required>
								    </div>
								    <div class="am-form-group">
								      <lable for="doc-vld-name-2" >年龄：</lable>
								      <input type="text" id="age" name="age">
								    </div>
								    <div class="am-form-group">
								      <lable for="doc-vld-name-2" >性别：</lable>
								      <input type="text" id="sex" name="sex">
								    </div>
								    <div class="am-form-group" style="display:none">
								      <lable for="doc-vld-name-2" >ID：</lable>
								      <input type="text" id="id" name="id">
								    </div>
								    <button type="submit" class="am-btn am-btn-success am-round am-btn-secondary" id="saveUseType"  style="margin-right:20px;margin-left:34%;">保存</button>
								    <button id="btn-canncel" type="button" class="am-btn am-btn-default am-round" style="margin-left:20px;margin-right:30%;" onclick="formReset()">取消</button>
								  </fieldset>
								</form>
							</div>
							
						</div>
					</div>
				</div>

				<!-- 弹窗 -->
					
				</div>
			</div>
		</div>
	</div>
</body>
<script type="text/javascript">
var params={
		
};
$(function(){
	initData();
	
	
function initData(){
	  table = $('#useTable').DataTable({
	      "responsive" : true,
	      "processing" : true,
	      "bSort" : false,
	      "ajax" : {
	               "type" : "get",
	               "url" : "<%=request.getContextPath()%>/user/getUserList",
	                "data" : function(d) {
											return $.extend({}, d, params);
										}
	               },
	      "columns" : [{"data" : "id","sDefaultContent" : "" },
	    	           {"data" : "userName","sDefaultContent" : "" },
	                   {"data" : "password","orderable": false,"sDefaultContent" : ""},
	                   {"data" : "age","orderable": false,"sDefaultContent" : ""},
	                   {"data" : "sex","sDefaultContent" : "" },
	                   {"data" : "","sDefaultContent" : "","render":function(data,type,row){
	                	   return '<button type="button" class="am-btn am-btn-default am-btn-xs am-text-secondary" onclick="find(\''+row.id+'\')"><span class="am-icon-pencil-square-o"></span>查看</button>';
	                   }},
	                   {"data" : "","orderable": false,"sDefaultContent" : "" ,
	                    "render":function(data,type,row){
							  return '<button type="button" class="am-btn am-btn-default am-btn-xs am-text-secondary" onclick="editUseType(\''+row.id+'\')"><span class="am-icon-pencil-square-o"></span> 编辑</button><button type="button" id="delBtn" name="delBtn" class="am-btn am-btn-default am-btn-xs am-text-danger am-text-secondary" onclick="deleteUseType('+row.CODE+')"><span class="am-icon-trash-o"></span> 删除</button>';}        
	                    }
	                  ]
	  });
   }
});
	  function formReset(){
		   document.getElementById("UseType").reset();  
		};
		 //新增按钮事件
		 $("#addBtn").on('click',function(){
		 
		    isAddOrEdit=0;
		    formReset();
		    //loadUSECODE();
		    //loadPROVINCE();
		 });	
		//取消
		$("#btn-canncel").on('click',function(){
				$("#my-popup").modal('close');
		});
		//保存
		$("#saveUseType").on('click',function(){
		if(isAddOrEdit==0){
					//var bol=false;
					var option={
				    type:'post',
				   dataType:'json',
				   clearForm:true,
				   url: "<%=request.getContextPath()%>/user/addUser",
				   success: function (data) {
				     //console.log(data);
				       if(data.success==true){
				       $('#my-alert1').modal('open');
				       $('#my-popup').modal('close');
				       table.ajax.reload();
				       }else if(data.success==false){
				       $('#my-alert2').modal('open');
				       $('#my-popup').modal('close');
				       table.ajax.reload();
				       }
				      }
				  };
             $("#UseType").ajaxForm(option);
             }else if(isAddOrEdit==1){
		                 var option={
							    type:'post',
							   dataType:'json',
							   clearForm:true,
							   url: "<%=request.getContextPath()%>/user/updateUser",
							   success: function (data) {
							     //console.log(data);
							       if(data.success==true){
							    	   $('#my-alert1').modal('open');
								       $('#my-popup').modal('close');
								       table.ajax.reload();
							       }else if(data.success==false){
							    	   $('#my-alert2').modal('open');
								       $('#my-popup').modal('close');
								       table.ajax.reload();
				       }
	       
					      }
					  };
					   $("#UseType").ajaxForm(option);
			  }else{
			  alert("保存错误，请联系管理员");
		  }
		});
		
		//编辑
		function editUseType(id){
			isAddOrEdit=1;
			$.ajax({
				type:'post',
				dataType:'json',
				data:{
					id:id
				},
				url : '<%=request.getContextPath()%>/user/getUserById',
						success : function(data) {
					try {
						//var pupData = $.parseJSON(data)[0];
						//$('#newUseType').setForm(jsData);
						$('#id').val(data.id);
						$('#userName').val(data.userName);
						$('#password').val(data.password);
						$('#age').val(data.age);
						$('#sex').val(data.sex);           
					} catch (e) {
					}
				},
				error : function() {
				},
				complete : function() {
					$('#map-loading').hide();
				}
			});
	$('#my-popup').modal('open');
		}
		
</script>
</html>