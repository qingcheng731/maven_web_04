<!DOCTYPE HTML>
<html lang="zh-CN">
<head>
<meta name="Generator" content="ZhangJi" />
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<title>会员注册</title>
<link href="${request.contextPath}/static/css/regstyle.css" rel="stylesheet" type="text/css">
<link href="${request.contextPath}/static/css/valid.css" rel="stylesheet" type="text/css">

<#include "inc/default_css.ftl">
<script type="text/javascript" src="${request.contextPath}/static/js/Validform_v5.3.2_min.js"></script>
<script type="text/javascript">
			$(function(){
					$.ajax({
					   type: "POST",
					   url: "/springmvc_demo01/user/ajaxFindDepts",
					   success: function(data){
					   		$('select').find("option").remove(); 
					   		$('select').append("<option value='0'>请选择</option>");
					   		var jsonobj = JSON.parse(data);
					   		$(jsonobj).each(function(i){
							 	 $('select').append("<option value='"+jsonobj[i].deptid+"'>"+jsonobj[i].deptname+"</option>");
							});
					   }
					});
				
				$('select').change(function(){
					var checkText=$("select").find("option:selected").val();
					$('select').attr("value",checkText);
				})
			})
		</script>

</head>

<body style="background:#fff;">

<div class="hearder" style="padding:10px 0">
	<div class="warp">
        <a href="#"><img src=""></a>
    </div>
</div>

<div class="warp regCont" style="margin-top:-60px;margin-bottom: 100px;">
	<div class="tittle">
    	<h1>注册您的帐户</h1>
        <p>已有账户，<a href="login.html">马上登陆</a></p>
    </div>
    <div style="padding:20px 20px 40px;">
        <form method="post" action="${request.contextPath}/user/addEmp" class="" id="register" enctype="multipart/form-data">
            <div class="valGroup">
                <div class="valGroup-item-1 inline-block"><span>*</span> 用户名：</div> 
                <div class="valGroup-item-2 formControls inline-block">
                    <input type="text" class="input-text-1" datatype="s3-12"  ajaxurl="${request.contextPath}/user/validUsername" sucmsg="用户名验证通过！" nullmsg="请输入用户名！" errormsg="请输入3-16个文字"  name="username" id="username" placeholder="3~12个字符，只接受字母和数字">
                </div>
                <div class="inline-block"></div>
            </div>
            <div class="valGroup">
                <div class="valGroup-item-1 inline-block"><span>*</span> 密码：</div>
                <div class="valGroup-item-2 formControls inline-block">
                    <input type="password" class="input-text-1"  name="password" id="password"   placeholder="可由6-18位英文、数字及标点组成">
                </div>
                <div class="inline-block"></div>
            </div>            
            <div class="valGroup">
                <div class="valGroup-item-1 inline-block"><span>*</span> email：</div>
                <div class="valGroup-item-2 formControls inline-block">
                    <input type="text" class="input-text-1"  datatype="e"   name="email" id="email"   placeholder="">
                </div>
                <div class="inline-block"></div>
            </div>
         
            <div class="valGroup">
                <div class="valGroup-item-1 inline-block"><span>*</span> 手机号码：</div>
                <div class="valGroup-item-2 formControls inline-block">
                    <input type="tel" class="input-text-1" datatype="m" name="tel" id="tel"  placeholder="请输入手机号码">
                </div>
                <div class="inline-block"></div>
                
            </div> 
             <div class="valGroup">
                <div class="valGroup-item-1 inline-block"><span>*</span> 请选择部门：</div>
                <div class="valGroup-item-2 formControls inline-block">
                	<select name="selectDept">
                		<option value="0">请选择</option>
                	</select>
                    <!-- <input type="tel" class="input-text-1" datatype="s" name="deptName" id="deptname"  placeholder="请输入部门名称"> -->
                </div>
                <div class="inline-block"></div>
            </div> 
            
            <div class="valGroup">
                <div class="valGroup-item-1 inline-block"><span>*</span> 请选择头像：</div>
                <div class="valGroup-item-2 formControls inline-block">
                	
                	<input type="file" datatype="*" name="uplodFile">
                </div>
                <div class="inline-block"></div>
            </div> 
            
            <div class="valGroup">
                <div class="valGroup-item-1 inline-block">&nbsp;</div>
                <div class="valGroup-item-2 formControls inline-block">
                    <label class="checkbox">
                      <input type="checkbox" name="checkAggree" id="checkAggree" checked style="border:0;position: relative; margin:0; top:2px;"> 我已阅读并同意
                    </label>
                    <a href="javascript:void(0)" class="xieyi">《蓝桥学生报名协议》</a>
                </div>
                <div class="inline-block"></div>
            </div>                                               
               
            <div class="valGroup">
                <div class="valGroup-item-1 inline-block">&nbsp;</div>
                <div class="valGroup-item-2 inline-block">
                    <input class="valGroup-btn" type="submit" value="&nbsp;&nbsp;确定注册&nbsp;&nbsp;">
                    <a style="cursor:pointer;display:none" id="btn_sub" target="_blank" class="valGroup-btn">确定注册</a>
                </div>
            </div>
        </form>
    </div>
    
</div>
	<script>
		$(document).ready(function(){
			var demo = $("#register").Validform({
				tiptype:2
			});
		})
	</script>
</body>
</html>



