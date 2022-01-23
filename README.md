<h1>Automation Mobile project Applaudo Challenge</h1>

<p>This project was designed to measure the knowledge of Luis Malave in the automation mobile, the technologies implemented in this project are:</p>

<h2><b>Architecture</b></h2>

<ul>
    <li><b>Program language: </b>Java</li>
    <li><b>Test Framework: </b>TestGN</li>
    <li><b>Automation pattern design: </b>Page Object Model</li>
    <li><b>Build automation tool: </b>Maven</li>
    <li><b>Report: </b>Cucumber Report</li>
</ul>

<h2><b>Preconditions:</b></h2>

<ul>
    <li>Installed Java 8</li>
    <li>Installed Maven</li>
    <li>Installed Git</li>
</ul>

<h2><b>Steps to execution:</b></h2>

<ul>
    <li>Clone the repository in a folder with the next command on your cmd or terminal: <code>git clone https://github.com/lmalave89/ApplaudoMobileChallenge.git</code></li>
    <li>Open the project in the IDE of your preference</li>
    <li>Depending of the IDE, maybe you should import the dependencies manually or synchronize manually</li> 
    <li>To execute the automation (It is necessary have installed the TestGN plugins),should execute the suite.xml file (using IDE or CMD)</li>
    <li>For visualize the report generate for the automation framework you should go the the "target/cucumber-reports/cucumber-pretty/index.html"</li>
</ul>

<h2><b>Notes:</b></h2>

<ul>
    <li>There are implemented workarounds in the automation because the app has trouble with the interaction with the "sendkeys" function, and in the section to delete the archived list, throughout the button with the three points was necessary to implement tap by coordinators</li>
    <li>Since was implemented tap by coordinators, attached the properties of the simulator implemented
        <ul>
            <li>Galaxy Nexus</li>
            <li>Android 11.0</li>
            <li>API 30 System Image  x86</li>
            <li>Size 4.65  x hdpi</li> 
            <li>Resolution 720x1280</li>
            <li>Density xhdpi</li>
        </ul>
    </li>
    <li>The last item of the challenge mobile doesn't implemented "<i>Consider using a devicefarm like BrowserStack or Kobiton so that your
challenge test can be tested with real remote devices.</i>"</li>
</ul>
