<%@ page language="java" contentType="text/html; charset=UTF-8"
   pageEncoding="UTF-8"%>
<%@page import="com.min.vo.*"%>
 <%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html lang="en">
  <head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta name="description" content="viho admin is super flexible, powerful, clean &amp; modern responsive bootstrap 4 admin template with unlimited possibilities.">
    <meta name="keywords" content="admin template, viho admin template, dashboard template, flat admin template, responsive admin template, web app">
    <meta name="author" content="pixelstrap">
    <link rel="icon" href="./assets/images/favicon.png" type="image/x-icon">
    <link rel="shortcut icon" href="./assets/images/favicon.png" type="image/x-icon">
    <title>viho - Premium Admin Template</title>
    <!-- Google font-->
    <link rel="preconnect" href="https://fonts.gstatic.com">
    <link href="https://fonts.googleapis.com/css2?family=Montserrat:ital,wght@0,100;0,200;0,300;0,400;0,500;0,600;0,700;0,800;0,900;1,100;1,200;1,300;1,400;1,500;1,600;1,700;1,800;1,900&amp;display=swap" rel="stylesheet">
    <link href="https://fonts.googleapis.com/css2?family=Roboto:ital,wght@0,100;0,300;0,400;0,500;0,700;0,900;1,100;1,300;1,400;1,500;1,700;1,900&amp;display=swap" rel="stylesheet">
    <link href="https://fonts.googleapis.com/css2?family=Rubik:ital,wght@0,400;0,500;0,600;0,700;0,800;0,900;1,300;1,400;1,500;1,600;1,700;1,800;1,900&amp;display=swap" rel="stylesheet">
    <!-- Font Awesome-->
    <link rel="stylesheet" type="text/css" href="./assets/css/fontawesome.css">
    <!-- ico-font-->
    <link rel="stylesheet" type="text/css" href="./assets/css/icofont.css">
    <!-- Themify icon-->
    <link rel="stylesheet" type="text/css" href="./assets/css/themify.css">
    <!-- Flag icon-->
    <link rel="stylesheet" type="text/css" href="./assets/css/flag-icon.css">
    <!-- Feather icon-->
    <link rel="stylesheet" type="text/css" href="./assets/css/feather-icon.css">
    <!-- Plugins css start-->
    <link rel="stylesheet" type="text/css" href="./assets/css/sweetalert2.css">
    <!-- Plugins css Ends-->
    <!-- Bootstrap css-->
    <link rel="stylesheet" type="text/css" href="./assets/css/bootstrap.css">
    <!-- App css-->
    <link rel="stylesheet" type="text/css" href="./assets/css/style.css">
    <link id="color" rel="stylesheet" href="./assets/css/color-1.css" media="screen">
    <!-- Responsive css-->
    <link rel="stylesheet" type="text/css" href="./assets/css/responsive.css">
  </head>
  <body>
    <!-- Loader starts-->
    <div class="loader-wrapper">
      <div class="theme-loader">    
        <div class="loader-p"></div>
      </div>
    </div>
    <!-- Loader ends-->
    <!-- page-wrapper Start-->
     <!-- Page Sidebar Ends-->
        <div class="page-body">
          <div class="container-fluid">
            <div class="page-header">
              <div class="row">
                <div class="col-sm-6">
                  <h3>Form Wizard With Icon</h3>
                  <ol class="breadcrumb">
                    <li class="breadcrumb-item"><a href="index.html">Home</a></li>
                    <li class="breadcrumb-item">Forms   </li>
                    <li class="breadcrumb-item">Form Layout</li>
                    <li class="breadcrumb-item active">Form Wizard 3</li>
                  </ol>
                </div>
                <div class="col-sm-6">
                  <!-- Bookmark Start-->
                  <div class="bookmark">
                    <ul>
                      <li><a href="javascript:void(0)" data-container="body" data-bs-toggle="popover" data-placement="top" title="" data-original-title="Tables"><i data-feather="inbox"></i></a></li>
                      <li><a href="javascript:void(0)" data-container="body" data-bs-toggle="popover" data-placement="top" title="" data-original-title="Chat"><i data-feather="message-square"></i></a></li>
                      <li><a href="javascript:void(0)" data-container="body" data-bs-toggle="popover" data-placement="top" title="" data-original-title="Icons"><i data-feather="command"></i></a></li>
                      <li><a href="javascript:void(0)" data-container="body" data-bs-toggle="popover" data-placement="top" title="" data-original-title="Learning"><i data-feather="layers"></i></a></li>
                      <li><a href="javascript:void(0)"><i class="bookmark-search" data-feather="star"></i></a>
                        <form class="form-inline search-form">
                          <div class="form-group form-control-search">
                            <input type="text" placeholder="Search..">
                          </div>
                        </form>
                      </li>
                    </ul>
                  </div>
                  <!-- Bookmark Ends-->
                </div>
              </div>
            </div>
          </div>
          <!-- Container-fluid starts-->
          <div class="container-fluid">
            <div class="row">
              <div class="col-sm-12">
                <div class="card">
                  <div class="card-header pb-0">
                    <h5>Form Wizard with icon</h5>
                  </div>
                  <div class="card-body">
                    <form class="f1" method="post">
                      <div class="f1-steps">
                        <div class="f1-progress">
                          <div class="f1-progress-line" data-now-value="16.66" data-number-of-steps="3"></div>
                        </div>
                        <div class="f1-step active">
                          <div class="f1-step-icon"><i class="fa fa-user"></i></div>
                          <p>Registration</p>
                        </div>
                        <div class="f1-step">
                          <div class="f1-step-icon"><i class="fa fa-key"></i></div>
                          <p>Email</p>
                        </div>
                        <div class="f1-step">
                          <div class="f1-step-icon"><i class="fa fa-twitter"></i></div>
                          <p>Birth Date</p>
                        </div>
                      </div>
                      <fieldset>
                        <div class="form-group">
                          <label for="f1-first-name">First Name</label>
                          <input class="form-control" id="f1-first-name" type="text" name="f1-first-name" placeholder="name@example.com" required="">
                        </div>
                        <div class="form-group">
                          <label for="f1-last-name">Last name</label>
                          <input class="f1-last-name form-control" id="f1-last-name" type="text" name="f1-last-name" placeholder="Last name..." required="">
                        </div>
                        <div class="f1-buttons">
                          <button class="btn btn-primary btn-next" type="button">Next</button>
                        </div>
                      </fieldset>
                      <fieldset>
                        <div class="form-group">
                          <label class="sr-only" for="f1-email">Email</label>
                          <input class="f1-email form-control" id="f1-email" type="text" name="f1-email" placeholder="Email..." required="">
                        </div>
                        <div class="form-group">
                          <label class="sr-only" for="f1-password">Password</label>
                          <input class="f1-password form-control" id="f1-password" type="password" name="f1-password" placeholder="Password..." required="">
                        </div>
                        <div class="form-group">
                          <label class="sr-only" for="f1-repeat-password">Repeat password</label>
                          <input class="f1-repeat-password form-control" id="f1-repeat-password" type="password" name="f1-repeat-password" placeholder="Repeat password..." required="">
                        </div>
                        <div class="f1-buttons">
                          <button class="btn btn-primary btn-previous" type="button">Previous</button>
                          <button class="btn btn-primary btn-next" type="button">Next</button>
                        </div>
                      </fieldset>
                      <fieldset>
                        <div class="form-group">
                          <label class="sr-only">DD</label>
                          <input class="form-control" id="dd" type="number" placeholder="dd" required="">
                        </div>
                        <div class="form-group">
                          <label class="sr-only">MM</label>
                          <input class="form-control" id="mm" type="number" placeholder="mm" required="">
                        </div>
                        <div class="form-group">
                          <label class="sr-only">YYYY</label>
                          <input class="form-control" id="yyyy" type="number" placeholder="yyyy" required="">
                        </div>
                        <div class="f1-buttons">
                          <button class="btn btn-primary btn-previous" type="button">Previous</button>
                          <button class="btn btn-primary btn-submit" type="submit">Submit</button>
                        </div>
                      </fieldset>
                    </form>
                  </div>
                </div>
              </div>
            </div>
          </div>
          <!-- Container-fluid Ends-->
        </div>
    
    
    <section>         
      <div class="container-fluid p-0"> 
        <div class="row m-0">
          <div class="col-12 p-0">    
            <div class="login-card">
              <form class="theme-form login-form" method="post" action="./InsSingUpSc.do">
                <h4>강사 회원가입</h4>
                <h6>Enter your personal details to create account</h6>
                <div class="form-group">
                  <label>Your Name</label>
                    <div class="input-group"><span class="input-group-text"><i class="icon-user"></i></span>
                    <input class="form-control" type="text" name="name" required="" placeholder="이름">
                  </div>
                  <div class="form-group">
                  <label>아이디</label>
                  <div class="input-group"><span class="input-group-text"><i class="icon-email"></i></span>
                    <input class="form-control" type="text" name="id" required="" placeholder="id" >
                  </div>
                   <div class="form-group">
                  <label>비밀번호</label>
                  <div class="input-group"><span class="input-group-text"><i class="icon-lock"></i></span>
                    <input class="form-control" type="password" name="pw" required="" placeholder="*********">
                    <div class="show-hide"><span class="show">                         </span></div>
                  </div>
                </div>
                </div>
                <label>전화번호</label>
                  <div class="small-group">
                    <div class="input-group"><span class="input-group-text"><i class="icon-user"></i></span>
                      <input class="form-control" type="text" name="phone" required="" placeholder="Fist Name">
                    </div>
  					</div>
  					<label>생년월일</label>
  					<div class="small-group">
  					
                    <div class="input-group"><span class="input-group-text"><i class="icon-user"></i></span>
                      <input class="form-control" type="text" name="birth" required="" placeholder="Last Name">
                    </div>
                  </div>
                  
                </div>
               <div class="row">
  <div class="col-lg-12">
    <div class="panel panel-default">

      <div class="panel-heading">File Attach</div>
      <!-- /.panel-heading -->
      <div class="panel-body">
        <div class="form-group uploadDiv">
            <input type="file" name='uploadFile' multiple>
        </div>
        
        <div class='uploadResult'> 
          <ul>
          
          </ul>
        </div>
        
        
      </div>
      <!--  end panel-body -->

    </div>
    <!--  end panel-body -->
  </div>
  <!-- end panel -->
</div>
 		<div class="form-group">
                  <label>임시 프로필</label>
                  <div class="input-group"><span class="input-group-text"><i class="icon-email"></i></span>
                    <input class="form-control" type="text" name="profile" required="" placeholder="Test@gmail.com">
                  </div>
                </div>
                <div class="form-group">
                  <label>Email Address</label>
                  <div class="input-group"><span class="input-group-text"><i class="icon-email"></i></span>
                    <input class="form-control" type="email" name="email" required="" placeholder="Test@gmail.com">
                  </div>
                </div>
              <div class="row form-builder-2">
    <div class="col-md-12">
        <div class="mb-3 ui-draggable-handle" style="position: static;">
            <label for="formcontrol-select1">은행</label>
            <select class="form-control btn-square" id="formcontrol-select1" name="bank">
            	<option>1</option>
            	<option>2</option>
            	<option>3</option>
            </select>
            <p class="help-block">Example block-level help text here.</p>
        </div>
        <div class="form-group">
                  <label>계좌번호</label>
                  <div class="input-group"><span class="input-group-text"><i class="icon-email"></i></span>
                    <input class="form-control" type="text" name="banknum" required="" placeholder="Test@gmail.com">
                  </div>
                </div>
    </div>
</div>
                <div class="form-group">
                  <div class="checkbox">
                    <input id="checkbox1" type="checkbox">
                    <label class="text-muted" for="checkbox1">Agree with <span>Privacy Policy                   </span></label>
                  </div>
                </div>
                <div class="form-group">
                  <button class="btn btn-primary btn-block" type="submit">Create Account</button>
                </div>
                <div class="login-social-title">                
                  <h5>signup with</h5>
                </div>
                <div class="form-group">
                  <ul class="login-social">
                    <li><a href="https://www.linkedin.com/login" target="_blank"><i data-feather="linkedin"></i></a></li>
                    <li><a href="https://www.linkedin.com/login" target="_blank"><i data-feather="twitter"></i></a></li>
                    <li><a href="https://www.linkedin.com/login" target="_blank"><i data-feather="facebook"></i></a></li>
                    <li><a href="https://www.instagram.com/login" target="_blank"><i data-feather="instagram">                  </i></a></li>
                  </ul>
                </div>
                <p>Already have an account?<a class="ms-2" href="./loginPage.do">Sign in</a></p>
              </form>
            </div>
          </div>
        </div>
      </div>
    </section>
  
        
    <!-- page-wrapper end-->
    <!-- latest jquery-->
    <script type="text/javascript">
    $(document).ready(function(e){

    	/* 
      var formObj = $("form[role='form']");
      
      $("button[type='submit']").on("click", function(e){
        
        e.preventDefault();
        
        console.log("submit clicked");
        
      }); */

      
      var formObj = $("form[role='form']");
      
      $("button[type='submit']").on("click", function(e){
        
        e.preventDefault();
        
        console.log("submit clicked");
        
        var str = "";
        
        $(".uploadResult ul li").each(function(i, obj){
          
          var jobj = $(obj);
          
          console.dir(jobj);
          console.log("-------------------------");
          console.log(jobj.data("filename"));
          
          
          str += "<input type='hidden' name='attachList["+i+"].fileName' value='"+jobj.data("filename")+"'>";
          str += "<input type='hidden' name='attachList["+i+"].uuid' value='"+jobj.data("uuid")+"'>";
          str += "<input type='hidden' name='attachList["+i+"].uploadPath' value='"+jobj.data("path")+"'>";
          str += "<input type='hidden' name='attachList["+i+"].fileType' value='"+ jobj.data("type")+"'>";
          
        });
        
        console.log(str);
        
        formObj.append(str).submit();
        
      });

      
      var regex = new RegExp("(.*?)\.(exe|sh|zip|alz)$");
      var maxSize = 5242880; //5MB
      
      function checkExtension(fileName, fileSize){
        
        if(fileSize >= maxSize){
          alert("파일 사이즈 초과");
          return false;
        }
        
        if(regex.test(fileName)){
          alert("해당 종류의 파일은 업로드할 수 없습니다.");
          return false;
        }
        return true;
      }
      
      $("input[type='file']").change(function(e){

        var formData = new FormData();
        
        var inputFile = $("input[name='uploadFile']");
        
        var files = inputFile[0].files;
        
        for(var i = 0; i < files.length; i++){

          if(!checkExtension(files[i].name, files[i].size) ){
            return false;
          }
          formData.append("uploadFile", files[i]);
          
        }
        
        $.ajax({
          url: '/uploadAjaxAction',
          processData: false, 
          contentType: false,data: 
          formData,type: 'POST',
          dataType:'json',
            success: function(result){
              console.log(result); 
    		  showUploadResult(result); //업로드 결과 처리 함수 

          }
        }); //$.ajax
        
      });  
      
      function showUploadResult(uploadResultArr){
    	    
        if(!uploadResultArr || uploadResultArr.length == 0){ return; }
        
        var uploadUL = $(".uploadResult ul");
        
        var str ="";
        
        $(uploadResultArr).each(function(i, obj){
        
            /* //image type
            if(obj.image){
              var fileCallPath =  encodeURIComponent( obj.uploadPath+ "/s_"+obj.uuid +"_"+obj.fileName);
              str += "<li><div>";
              str += "<span> "+ obj.fileName+"</span>";
              str += "<button type='button' data-file=\'"+fileCallPath+"\' data-type='image' class='btn btn-warning btn-circle'><i class='fa fa-times'></i></button><br>";
              str += "<img src='/display?fileName="+fileCallPath+"'>";
              str += "</div>";
              str +"</li>";
            }else{
              var fileCallPath =  encodeURIComponent( obj.uploadPath+"/"+ obj.uuid +"_"+obj.fileName);            
                var fileLink = fileCallPath.replace(new RegExp(/\\/g),"/");
                  
              str += "<li><div>";
              str += "<span> "+ obj.fileName+"</span>";
              str += "<button type='button' data-file=\'"+fileCallPath+"\' data-type='file' class='btn btn-warning btn-circle'><i class='fa fa-times'></i></button><br>";
              str += "<img src='/resources/img/attach.png'></a>";
              str += "</div>";
              str +"</li>";
            } */
    		//image type
    		
    		if(obj.image){
    			var fileCallPath =  encodeURIComponent( obj.uploadPath+ "/s_"+obj.uuid +"_"+obj.fileName);
    			str += "<li data-path='"+obj.uploadPath+"'";
    			str +=" data-uuid='"+obj.uuid+"' data-filename='"+obj.fileName+"' data-type='"+obj.image+"'"
    			str +" ><div>";
    			str += "<span> "+ obj.fileName+"</span>";
    			str += "<button type='button' data-file=\'"+fileCallPath+"\' "
    			str += "data-type='image' class='btn btn-warning btn-circle'><i class='fa fa-times'></i></button><br>";
    			str += "<img src='/display?fileName="+fileCallPath+"'>";
    			str += "</div>";
    			str +"</li>";
    		}else{
    			var fileCallPath =  encodeURIComponent( obj.uploadPath+"/"+ obj.uuid +"_"+obj.fileName);			      
    		    var fileLink = fileCallPath.replace(new RegExp(/\\/g),"/");
    		      
    			str += "<li "
    			str += "data-path='"+obj.uploadPath+"' data-uuid='"+obj.uuid+"' data-filename='"+obj.fileName+"' data-type='"+obj.image+"' ><div>";
    			str += "<span> "+ obj.fileName+"</span>";
    			str += "<button type='button' data-file=\'"+fileCallPath+"\' data-type='file' " 
    			str += "class='btn btn-warning btn-circle'><i class='fa fa-times'></i></button><br>";
    			str += "<img src='/resources/img/attach.png'></a>";
    			str += "</div>";
    			str +"</li>";
    		}

        });
        
        uploadUL.append(str);
      }

      $(".uploadResult").on("click", "button", function(e){
    	    
        console.log("delete file");
          
        var targetFile = $(this).data("file");
        var type = $(this).data("type");
        
        var targetLi = $(this).closest("li");
        
        $.ajax({
          url: '/deleteFile',
          data: {fileName: targetFile, type:type},
          dataType:'text',
          type: 'POST',
            success: function(result){
               alert(result);
               
               targetLi.remove();
             }
        }); //$.ajax
       });
    });</script>
    <script src="./assets/js/jquery-3.5.1.min.js"></script>
    <!-- feather icon js-->
    <script src="./assets/js/icons/feather-icon/feather.min.js"></script>
    <script src="./assets/js/icons/feather-icon/feather-icon.js"></script>
    <!-- Sidebar jquery-->
    <script src="./assets/js/sidebar-menu.js"></script>
    <script src="./assets/js/config.js"></script>
    <!-- Bootstrap js-->
    <script src="./assets/js/bootstrap/popper.min.js"></script>
    <script src="./assets/js/bootstrap/bootstrap.min.js"></script>
    <!-- Plugins JS start-->
    <script src="./assets/js/sweet-alert/sweetalert.min.js"></script>
    <!-- Plugins JS Ends-->
    <!-- Theme js-->
    <script src="./assets/js/script.js"></script>
    <!-- login js-->
    <!-- Plugin used-->
   
  </body>
</html>