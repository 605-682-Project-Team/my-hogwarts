
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="icon" href="../resources/images/hogwarts_crest_icon.ico">
<link href="../resources/css/lib/bootstrap.min.css" rel="stylesheet">
  <link href="../resources/css/dashboard.css" rel="stylesheet">
<script src="../resources/js/lib/jquery-3.3.1.min.js"></script>
<script src="../resources/js/lib/bootstrap.min.js"></script>
<script src="../resources/js/lib/popper.min.js"></script>

<title>My Hogwarts Dashboard</title>
</head>

<body class="bg-light">
	 <%@ include file="fragments/navbar.jsp" %>
	 <main role="main">

      <div id="myCarousel" class="carousel slide" data-ride="carousel">
        <ol class="carousel-indicators">
          <li data-target="#myCarousel" data-slide-to="0" class="active"></li>
          <li data-target="#myCarousel" data-slide-to="1"></li>
          <li data-target="#myCarousel" data-slide-to="2"></li>
        </ol>
        <div class="carousel-inner">
          <div class="carousel-item active">
            <img class="first-slide" src="../resources/images/hogwarts-castle.jpg" alt="First slide">
            <div class="container">
              <div class="carousel-caption text-left">
                <h1>Historic Hogwarts Castle</h1>
                <p>Live and learn in the historic (c. 993) Hogwarts castle.</p>
              </div>
            </div>
          </div>
          <div class="carousel-item">
            <img class="second-slide" src="../resources/images/quidditch.jpg" alt="Second slide">
            <div class="container">
              <div class="carousel-caption">
                <h1>Athletics</h1>
                <p>Participate in character building competition by representing your house in Quidditch.</p>
              </div>
            </div>
          </div>
          <div class="carousel-item">
            <img class="third-slide" src="../resources/images/great-hall.jpg" alt="Third slide">
            <div class="container">
              <div class="carousel-caption text-right">
                <h1>World Class Dining</h1>
                <p>Refuel with the finest cuisine prepared by the Hogwarts house-elfs.</p>
              </div>
            </div>
          </div>
        </div>
        <a class="carousel-control-prev" href="#myCarousel" role="button" data-slide="prev">
          <span class="carousel-control-prev-icon" aria-hidden="true"></span>
          <span class="sr-only">Previous</span>
        </a>
        <a class="carousel-control-next" href="#myCarousel" role="button" data-slide="next">
          <span class="carousel-control-next-icon" aria-hidden="true"></span>
          <span class="sr-only">Next</span>
        </a>
      </div>
      </main>
      <p class="mt-5 mb-3 text-muted text-center">&copy; 2018 Hogwarts School of Witchcraft and Wizardry</p>
</body>

</html>