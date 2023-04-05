
<html>
<head>
  <title>SideBar Menu</title>
  <style>
    body{
      margin:0px;
      padding:0px;
      font-family:"Helvetica Neue", Helvetica, Arial;
    }

    #sidebar{
      background:#151718;
      width:200px;
      height:100%;
      display:block;
      position:absolute;
      left:-200px;
      top:0px;
      transition:left 0.3s linear;
    }

    #sidebar.visible{
      left:0px;
      transition:left 0.3s linear;
    }

    ul{
      margin:0px;
      padding:0px;
    }

    ul li{
      list-style:none;
    }

    ul li a{
      background:#1C1E1F;
      color:#ccc;
      border-bottom:1px solid #111;
      display:block;
      width:180px;
      padding:10px;
      text-decoration: none;
    }

    #sidebar-btn{
      display:inline-block;
      vertical-align: middle;
      width:20px;
      height:15px;
      cursor:pointer;
      margin:20px;
      position:absolute;
      top:0px;
      right:-60px;
    }

    #sidebar-btn span{
      height:1px;
      background:#111;
      margin-bottom:5px;
      display:block;
    }

    #sidebar-btn span:nth-child(2){
      width:75%;
    }

    #sidebar-btn span:nth-child(3){
      width:50%;
    }
  </style>
</head>
<body>

<div id="sidebar">

  <ul>
    <li><a href="./studentDetails.jsp">Student Details</a></li>
    <li><a href="./teacherDetails.jsp">Teacher Details</a></li>
    <li><a href="#">Sign Out</a></li>

  </ul>

  <div id="sidebar-btn">
    <span></span>
    <span></span>
    <span></span>
  </div>

</div>



<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
<script>

  $(document).ready(function(){
    $('#sidebar-btn').click(function(){
      $('#sidebar').toggleClass('visible');
    });
  });

</script>

</body>
</html>
