import org.scalatest.FunSpec
import repositories.{DirectionsRepository, ElevationRepository}
import Core._

class TestCore extends FunSpec {
  describe(".elevationProfile") {
    val from        = "2 McGoun St, Melbourne, Australia"
    val to          = "511 Church St, Melbourne, Australia"
    val directions  = new TestDirectionClient("")
    val elevation   = new TestElevationClient("")

    it("calculates the elevation profile of the routes") {
      assert(elevationProfile(from, to, directions, elevation).right.get.length == 3)
    }
  }
}

class TestDirectionClient(apiKey: String) extends DirectionsRepository(apiKey: String) {
  val response = """{"geocoded_waypoints":[{"geocoder_status":"OK","place_id":"ChIJb9Xnx_FC1moR3g-lBGt5nsM","types":["street_address"]},{"geocoder_status":"OK","place_id":"ChIJbcFfKIxC1moRMlcM4AsX2-w","types":["street_address"]}],"routes":[{"bounds":{"northeast":{"lat":-37.8164005,"lng":144.9994843},"southwest":{"lat":-37.8287644,"lng":144.9955671}},"copyrights":"Map data ©2016 Google","legs":[{"distance":{"text":"1.8 km","value":1797},"duration":{"text":"7 mins","value":442},"end_address":"511 Church St, Cremorne VIC 3121, Australia","end_location":{"lat":-37.8287644,"lng":144.9980297},"start_address":"2 Mcgoun St, Richmond VIC 3121, Australia","start_location":{"lat":-37.8168987,"lng":144.9955671},"steps":[{"distance":{"text":"56 m","value":56},"duration":{"text":"1 min","value":7},"end_location":{"lat":-37.816969,"lng":144.9961949},"html_instructions":"Head <b>east</b> on <b>Mcgoun St</b> toward <b>Thomas St</b>","polyline":{"points":"rbyeFim~sZL{B"},"start_location":{"lat":-37.8168987,"lng":144.9955671},"travel_mode":"BICYCLING"},{"distance":{"text":"64 m","value":64},"duration":{"text":"1 min","value":8},"end_location":{"lat":-37.8164005,"lng":144.9962741},"html_instructions":"Turn <b>left</b> onto <b>Thomas St</b>","maneuver":"turn-left","polyline":{"points":"`cyeFeq~sZqBO"},"start_location":{"lat":-37.816969,"lng":144.9961949},"travel_mode":"BICYCLING"},{"distance":{"text":"0.3 km","value":286},"duration":{"text":"1 min","value":46},"end_location":{"lat":-37.8168081,"lng":144.9994843},"html_instructions":"Turn <b>right</b> onto <b>Cameron St</b>","maneuver":"turn-right","polyline":{"points":"n_yeFuq~sZ@WPaDReDDUDUBk@Fy@Dq@?GJuA"},"start_location":{"lat":-37.8164005,"lng":144.9962741},"travel_mode":"BICYCLING"},{"distance":{"text":"1.3 km","value":1334},"duration":{"text":"6 mins","value":373},"end_location":{"lat":-37.8286912,"lng":144.9973902},"html_instructions":"Turn <b>right</b> onto <b>Church St</b>","maneuver":"turn-right","polyline":{"points":"`byeFwe_tZn@FtBR|AP^Dr@HP@p@FzANjAJLBr@FrALF?`@F|@HzANj@D~BVdBPtAL|BTdBRVDhBNx@JhAJtAL|@JF@B@@?P@N@h@Fh@FN@h@FL@v@Hr@HD@VBh@DLBt@H"},"start_location":{"lat":-37.8168081,"lng":144.9994843},"travel_mode":"BICYCLING"},{"distance":{"text":"57 m","value":57},"duration":{"text":"1 min","value":8},"end_location":{"lat":-37.8287644,"lng":144.9980297},"html_instructions":"Turn <b>left</b> onto <b>Gibbons St</b><div style=\"font-size:0.9em\">Destination will be on the right</div>","maneuver":"turn-left","polyline":{"points":"hl{eFux~sZHsABk@"},"start_location":{"lat":-37.8286912,"lng":144.9973902},"travel_mode":"BICYCLING"}],"traffic_speed_entry":[],"via_waypoint":[]}],"overview_polyline":{"points":"rbyeFim~sZL{BqBORyDX{DHaAXiEbHr@tLhAjP~ApWjCxFl@t@HHsABk@"},"summary":"Church St","warnings":["Bicycling directions are in beta. Use caution – This route may contain streets that aren't suited for bicycling."],"waypoint_order":[]},{"bounds":{"northeast":{"lat":-37.8168681,"lng":145.0038488},"southwest":{"lat":-37.82881760000001,"lng":144.9950744}},"copyrights":"Map data ©2016 Google","legs":[{"distance":{"text":"2.4 km","value":2415},"duration":{"text":"9 mins","value":544},"end_address":"511 Church St, Cremorne VIC 3121, Australia","end_location":{"lat":-37.8287644,"lng":144.9980297},"start_address":"2 Mcgoun St, Richmond VIC 3121, Australia","start_location":{"lat":-37.8168987,"lng":144.9955671},"steps":[{"distance":{"text":"24 m","value":24},"duration":{"text":"1 min","value":6},"end_location":{"lat":-37.8168681,"lng":144.9952936},"html_instructions":"Head <b>west</b> on <b>Mcgoun St</b> toward <b>Judd St</b>","polyline":{"points":"rbyeFim~sZEv@"},"start_location":{"lat":-37.8168987,"lng":144.9955671},"travel_mode":"BICYCLING"},{"distance":{"text":"0.1 km","value":139},"duration":{"text":"1 min","value":53},"end_location":{"lat":-37.8181096,"lng":144.9950744},"html_instructions":"Turn <b>left</b> onto <b>Judd St</b>","maneuver":"turn-left","polyline":{"points":"lbyeFqk~sZvBT~BT"},"start_location":{"lat":-37.8168681,"lng":144.9952936},"travel_mode":"BICYCLING"},{"distance":{"text":"0.8 km","value":778},"duration":{"text":"2 mins","value":145},"end_location":{"lat":-37.81897379999999,"lng":145.0038488},"html_instructions":"Turn <b>left</b> onto <b>Bridge Rd</b>/<b>State Route 30</b>","maneuver":"turn-left","polyline":{"points":"djyeFej~sZFgAHsAFw@JgBDq@Bg@VoEP_DEm@?_@@QBu@?EF_AD}@FuAJeCDaAJqBDq@JiCH{A@S"},"start_location":{"lat":-37.8181096,"lng":144.9950744},"travel_mode":"BICYCLING"},{"distance":{"text":"0.9 km","value":932},"duration":{"text":"4 mins","value":247},"end_location":{"lat":-37.8272239,"lng":145.0022653},"html_instructions":"Turn <b>right</b> onto <b>Coppin St</b><div style=\"font-size:0.9em\">Go through 1 roundabout</div>","maneuver":"turn-right","polyline":{"points":"poyeFaa`tZXBFHZB\\Dv@HxAPlALvC\\~@Jh@Fd@DnANJAX@?A@??A@??A@?@?@??A@??@@?@?@@@??@@@?@@@PFLDTBh@FpD`@xD`@vC\\H@bAJ~@Jl@F`@DL@NBT@H@"},"start_location":{"lat":-37.81897379999999,"lng":145.0038488},"travel_mode":"BICYCLING"},{"distance":{"text":"9 m","value":9},"duration":{"text":"1 min","value":2},"end_location":{"lat":-37.8272141,"lng":145.002167},"html_instructions":"Turn <b>right</b> onto <b>Madden Grove</b>","maneuver":"turn-right","polyline":{"points":"bc{eFew_tZAR"},"start_location":{"lat":-37.8272239,"lng":145.0022653},"travel_mode":"BICYCLING"},{"distance":{"text":"29 m","value":29},"duration":{"text":"1 min","value":8},"end_location":{"lat":-37.8273861,"lng":145.0019389},"html_instructions":"Turn <b>left</b> toward <b>Mary St</b>","maneuver":"turn-left","polyline":{"points":"`c{eFqv_tZF@B??@@@@@DN@BDHDF"},"start_location":{"lat":-37.8272141,"lng":145.002167},"travel_mode":"BICYCLING"},{"distance":{"text":"67 m","value":67},"duration":{"text":"1 min","value":15},"end_location":{"lat":-37.827396,"lng":145.0012378},"html_instructions":"Turn <b>right</b> toward <b>Mary St</b>","maneuver":"turn-right","polyline":{"points":"dd{eFcu_tZCDCFEHALCT@P?JDN@B@B@B@B@B@B@H"},"start_location":{"lat":-37.8273861,"lng":145.0019389},"travel_mode":"BICYCLING"},{"distance":{"text":"0.1 km","value":109},"duration":{"text":"1 min","value":21},"end_location":{"lat":-37.8283175,"lng":145.0009481},"html_instructions":"Turn <b>left</b> toward <b>Mary St</b>","maneuver":"turn-left","polyline":{"points":"fd{eFwp_tZRHLBb@DPBH?H?JAL?b@NLR"},"start_location":{"lat":-37.827396,"lng":145.0012378},"travel_mode":"BICYCLING"},{"distance":{"text":"22 m","value":22},"duration":{"text":"1 min","value":3},"end_location":{"lat":-37.8282945,"lng":145.0006953},"html_instructions":"Turn <b>right</b> toward <b>Mary St</b>","maneuver":"turn-right","polyline":{"points":"~i{eF}n_tZEp@"},"start_location":{"lat":-37.8283175,"lng":145.0009481},"travel_mode":"BICYCLING"},{"distance":{"text":"36 m","value":36},"duration":{"text":"1 min","value":5},"end_location":{"lat":-37.8286142,"lng":145.0006317},"html_instructions":"Turn <b>left</b> onto <b>Mary St</b>","maneuver":"turn-left","polyline":{"points":"xi{eFkm_tZ~@L"},"start_location":{"lat":-37.8282945,"lng":145.0006953},"travel_mode":"BICYCLING"},{"distance":{"text":"0.1 km","value":141},"duration":{"text":"1 min","value":17},"end_location":{"lat":-37.8284414,"lng":144.9990419},"html_instructions":"Turn <b>right</b> onto <b>Davis St</b>","maneuver":"turn-right","polyline":{"points":"xk{eF}l_tZYnFGlA"},"start_location":{"lat":-37.8286142,"lng":145.0006317},"travel_mode":"BICYCLING"},{"distance":{"text":"8 m","value":8},"duration":{"text":"1 min","value":1},"end_location":{"lat":-37.8285165,"lng":144.9990284},"html_instructions":"Turn <b>left</b> onto <b>Brighton St</b>","maneuver":"turn-left","polyline":{"points":"vj{eF_c_tZF?F@"},"start_location":{"lat":-37.8284414,"lng":144.9990419},"travel_mode":"BICYCLING"},{"distance":{"text":"35 m","value":35},"duration":{"text":"1 min","value":6},"end_location":{"lat":-37.8284699,"lng":144.99863},"html_instructions":"Turn <b>right</b> onto <b>Albert St</b>","maneuver":"turn-right","polyline":{"points":"fk{eF}b_tZIhA?D"},"start_location":{"lat":-37.8285165,"lng":144.9990284},"travel_mode":"BICYCLING"},{"distance":{"text":"86 m","value":86},"duration":{"text":"1 min","value":15},"end_location":{"lat":-37.8287644,"lng":144.9980297},"html_instructions":"Turn <b>left</b> onto <b>Gibbons St</b><div style=\"font-size:0.9em\">Destination will be on the left</div>","maneuver":"turn-left","polyline":{"points":"|j{eFm`_tZz@H@?@?@@@??@@@?@?BARIlA"},"start_location":{"lat":-37.8284699,"lng":144.99863},"travel_mode":"BICYCLING"}],"traffic_speed_entry":[],"via_waypoint":[{"location":{"lat":-37.8209339,"lng":145.0034431},"step_index":3,"step_interpolation":0.2377871724290276}]}],"overview_polyline":{"points":"rbyeFim~sZEv@vBT~BTFgAPkCPyCZwFP_DEm@@q@B{@`@yIb@oJH{A@SXBFHZBtAN~JhAnALnANJAX?@??ABA@?D?DB@@RJb@HzEh@~KlA|CZd@DH@ARJ@@BN^DFCDIPEb@@\\JZFT`@Lt@Hl@Ab@NLREp@~@La@|HN@InA|@HD@@DKdB"},"summary":"Bridge Rd/State Route 30 and Coppin St","warnings":["Bicycling directions are in beta. Use caution – This route may contain streets that aren't suited for bicycling."],"waypoint_order":[]},{"bounds":{"northeast":{"lat":-37.8168987,"lng":144.9987558},"southwest":{"lat":-37.8287644,"lng":144.9943347}},"copyrights":"Map data ©2016 Google","legs":[{"distance":{"text":"2.1 km","value":2062},"duration":{"text":"8 mins","value":506},"end_address":"511 Church St, Cremorne VIC 3121, Australia","end_location":{"lat":-37.8287644,"lng":144.9980297},"start_address":"2 Mcgoun St, Richmond VIC 3121, Australia","start_location":{"lat":-37.8168987,"lng":144.9955671},"steps":[{"distance":{"text":"56 m","value":56},"duration":{"text":"1 min","value":7},"end_location":{"lat":-37.816969,"lng":144.9961949},"html_instructions":"Head <b>east</b> on <b>Mcgoun St</b> toward <b>Thomas St</b>","polyline":{"points":"rbyeFim~sZL{B"},"start_location":{"lat":-37.8168987,"lng":144.9955671},"travel_mode":"BICYCLING"},{"distance":{"text":"20 m","value":20},"duration":{"text":"1 min","value":8},"end_location":{"lat":-37.8171475,"lng":144.9961791},"html_instructions":"Turn <b>right</b> onto <b>Thomas St</b>","maneuver":"turn-right","polyline":{"points":"`cyeFeq~sZN@F@@?@?B?@?@A"},"start_location":{"lat":-37.816969,"lng":144.9961949},"travel_mode":"BICYCLING"},{"distance":{"text":"80 m","value":80},"duration":{"text":"1 min","value":10},"end_location":{"lat":-37.8172789,"lng":144.997071},"html_instructions":"Turn <b>left</b> onto <b>Hull St</b>","maneuver":"turn-left","polyline":{"points":"ddyeFcq~sZ?A@A?A@ETeD"},"start_location":{"lat":-37.8171475,"lng":144.9961791},"travel_mode":"BICYCLING"},{"distance":{"text":"0.1 km","value":117},"duration":{"text":"1 min","value":47},"end_location":{"lat":-37.8183266,"lng":144.9969005},"html_instructions":"Turn <b>right</b> onto <b>Bosisto St</b>","maneuver":"turn-right","polyline":{"points":"~dyeFuv~sZfBPB?dBN"},"start_location":{"lat":-37.8172789,"lng":144.997071},"travel_mode":"BICYCLING"},{"distance":{"text":"0.2 km","value":200},"duration":{"text":"1 min","value":81},"end_location":{"lat":-37.8180674,"lng":144.9946467},"html_instructions":"Turn <b>right</b> onto <b>Bridge Rd</b>/<b>State Route 30</b>","maneuver":"turn-right","polyline":{"points":"pkyeFsu~sZEp@KfBGv@IrAGfAGrA"},"start_location":{"lat":-37.8183266,"lng":144.9969005},"travel_mode":"BICYCLING"},{"distance":{"text":"0.2 km","value":179},"duration":{"text":"1 min","value":31},"end_location":{"lat":-37.819659,"lng":144.9943308},"html_instructions":"Turn <b>left</b> onto <b>Lennox St</b>","maneuver":"turn-left","polyline":{"points":"|iyeFqg~sZdALRBbFl@"},"start_location":{"lat":-37.8180674,"lng":144.9946467},"travel_mode":"BICYCLING"},{"distance":{"text":"0.2 km","value":225},"duration":{"text":"1 min","value":54},"end_location":{"lat":-37.8199945,"lng":144.9968204},"html_instructions":"At the roundabout, take the <b>1st</b> exit onto <b>Goodwood St</b>","maneuver":"roundabout-left","polyline":{"points":"zsyeFqe~sZ?A?A@??A?A@??A@?@??A@?LiBHeB^uG"},"start_location":{"lat":-37.819659,"lng":144.9943308},"travel_mode":"BICYCLING"},{"distance":{"text":"88 m","value":88},"duration":{"text":"1 min","value":16},"end_location":{"lat":-37.8207433,"lng":144.9967928},"html_instructions":"Turn <b>right</b> onto <b>Waltham St</b>","maneuver":"turn-right","polyline":{"points":"|uyeFcu~sZvBPJ@B@@?@?@?@A@??A@A@A?A?A?C"},"start_location":{"lat":-37.8199945,"lng":144.9968204},"travel_mode":"BICYCLING"},{"distance":{"text":"0.2 km","value":174},"duration":{"text":"1 min","value":31},"end_location":{"lat":-37.8209799,"lng":144.9987558},"html_instructions":"<b>Waltham St</b> turns slightly <b>left</b> and becomes <b>Darlington Parade</b>","polyline":{"points":"rzyeF}t~sZn@iK"},"start_location":{"lat":-37.8207433,"lng":144.9967928},"travel_mode":"BICYCLING"},{"distance":{"text":"0.9 km","value":866},"duration":{"text":"4 mins","value":213},"end_location":{"lat":-37.8286912,"lng":144.9973902},"html_instructions":"Turn <b>right</b> onto <b>Church St</b>","maneuver":"turn-right","polyline":{"points":"b|yeFga_tZzANj@D~BVdBPtAL|BTdBRVDhBNx@JhAJtAL|@JF@B@@?P@N@h@Fh@FN@h@FL@v@Hr@HD@VBh@DLBt@H"},"start_location":{"lat":-37.8209799,"lng":144.9987558},"travel_mode":"BICYCLING"},{"distance":{"text":"57 m","value":57},"duration":{"text":"1 min","value":8},"end_location":{"lat":-37.8287644,"lng":144.9980297},"html_instructions":"Turn <b>left</b> onto <b>Gibbons St</b><div style=\"font-size:0.9em\">Destination will be on the left</div>","maneuver":"turn-left","polyline":{"points":"hl{eFux~sZHsABk@"},"start_location":{"lat":-37.8286912,"lng":144.9973902},"travel_mode":"BICYCLING"}],"traffic_speed_entry":[],"via_waypoint":[{"location":{"lat":-37.8180885,"lng":144.9948605},"step_index":4,"step_interpolation":0.905381353204298}]}],"overview_polyline":{"points":"rbyeFim~sZL{BN@H@HABKTeDfBPhBNc@dHOzCxAPbFl@?A?A@A@CB?@ALiBh@{JbCRH@BABEn@qKlJ~@rEb@|BXbIt@jANtFh@zBTbALL_C"},"summary":"Church St","warnings":["Bicycling directions are in beta. Use caution – This route may contain streets that aren't suited for bicycling."],"waypoint_order":[]}],"status":"OK"}"""

  override def request(url: String): Either[String, String] = Right(response)

  override def directionsURL(from: String, to: String): Either[String, String] = Right("I won't hit the network.")
}

class TestElevationClient(apiKey: String) extends ElevationRepository(apiKey: String) {
  val response = """{"results":[{"elevation":21.20940589904785,"location":{"lat":-37.8168987,"lng":144.9955671},"resolution":9.543951988220215},{"elevation":18.11214256286621,"location":{"lat":-37.816969,"lng":144.9961949},"resolution":9.543951988220215},{"elevation":18.11214256286621,"location":{"lat":-37.816969,"lng":144.9961949},"resolution":9.543951988220215},{"elevation":17.21347236633301,"location":{"lat":-37.8164005,"lng":144.9962741},"resolution":9.543951988220215},{"elevation":17.21347236633301,"location":{"lat":-37.8164005,"lng":144.9962741},"resolution":9.543951988220215},{"elevation":15.56391048431396,"location":{"lat":-37.8168081,"lng":144.9994843},"resolution":9.543951988220215},{"elevation":15.56391048431396,"location":{"lat":-37.8168081,"lng":144.9994843},"resolution":9.543951988220215},{"elevation":10.29346084594727,"location":{"lat":-37.8286912,"lng":144.9973902},"resolution":9.543951988220215},{"elevation":10.29346084594727,"location":{"lat":-37.8286912,"lng":144.9973902},"resolution":9.543951988220215},{"elevation":11.15404796600342,"location":{"lat":-37.8287644,"lng":144.9980297},"resolution":9.543951988220215},{"elevation":21.20940589904785,"location":{"lat":-37.8168987,"lng":144.9955671},"resolution":9.543951988220215},{"elevation":22.5273494720459,"location":{"lat":-37.8168681,"lng":144.9952936},"resolution":9.543951988220215},{"elevation":22.5273494720459,"location":{"lat":-37.8168681,"lng":144.9952936},"resolution":9.543951988220215},{"elevation":27.95387077331543,"location":{"lat":-37.8181096,"lng":144.9950744},"resolution":9.543951988220215},{"elevation":27.95387077331543,"location":{"lat":-37.8181096,"lng":144.9950744},"resolution":9.543951988220215},{"elevation":13.35719108581543,"location":{"lat":-37.81897379999999,"lng":145.0038488},"resolution":9.543951988220215},{"elevation":13.35719108581543,"location":{"lat":-37.81897379999999,"lng":145.0038488},"resolution":9.543951988220215},{"elevation":11.51693058013916,"location":{"lat":-37.8272239,"lng":145.0022653},"resolution":9.543951988220215},{"elevation":11.51693058013916,"location":{"lat":-37.8272239,"lng":145.0022653},"resolution":9.543951988220215},{"elevation":11.44061851501465,"location":{"lat":-37.8272141,"lng":145.002167},"resolution":9.543951988220215},{"elevation":11.44061851501465,"location":{"lat":-37.8272141,"lng":145.002167},"resolution":9.543951988220215},{"elevation":11.7107629776001,"location":{"lat":-37.8273861,"lng":145.0019389},"resolution":9.543951988220215},{"elevation":11.7107629776001,"location":{"lat":-37.8273861,"lng":145.0019389},"resolution":9.543951988220215},{"elevation":13.08027076721191,"location":{"lat":-37.827396,"lng":145.0012378},"resolution":9.543951988220215},{"elevation":13.08027076721191,"location":{"lat":-37.827396,"lng":145.0012378},"resolution":9.543951988220215},{"elevation":12.65882873535156,"location":{"lat":-37.8283175,"lng":145.0009481},"resolution":9.543951988220215},{"elevation":12.65882873535156,"location":{"lat":-37.8283175,"lng":145.0009481},"resolution":9.543951988220215},{"elevation":13.57369613647461,"location":{"lat":-37.8282945,"lng":145.0006953},"resolution":9.543951988220215},{"elevation":13.57369613647461,"location":{"lat":-37.8282945,"lng":145.0006953},"resolution":9.543951988220215},{"elevation":12.42692947387695,"location":{"lat":-37.8286142,"lng":145.0006317},"resolution":9.543951988220215},{"elevation":12.42692947387695,"location":{"lat":-37.8286142,"lng":145.0006317},"resolution":9.543951988220215},{"elevation":11.16285228729248,"location":{"lat":-37.8284414,"lng":144.9990419},"resolution":9.543951988220215},{"elevation":11.16285228729248,"location":{"lat":-37.8284414,"lng":144.9990419},"resolution":9.543951988220215},{"elevation":11.15227890014648,"location":{"lat":-37.8285165,"lng":144.9990284},"resolution":9.543951988220215},{"elevation":11.15227890014648,"location":{"lat":-37.8285165,"lng":144.9990284},"resolution":9.543951988220215},{"elevation":10.40315628051758,"location":{"lat":-37.8284699,"lng":144.99863},"resolution":9.543951988220215},{"elevation":10.40315628051758,"location":{"lat":-37.8284699,"lng":144.99863},"resolution":9.543951988220215},{"elevation":11.15404796600342,"location":{"lat":-37.8287644,"lng":144.9980297},"resolution":9.543951988220215},{"elevation":21.20940589904785,"location":{"lat":-37.8168987,"lng":144.9955671},"resolution":9.543951988220215},{"elevation":18.11214256286621,"location":{"lat":-37.816969,"lng":144.9961949},"resolution":9.543951988220215},{"elevation":18.11214256286621,"location":{"lat":-37.816969,"lng":144.9961949},"resolution":9.543951988220215},{"elevation":18.32276725769043,"location":{"lat":-37.8171475,"lng":144.9961791},"resolution":9.543951988220215},{"elevation":18.32276725769043,"location":{"lat":-37.8171475,"lng":144.9961791},"resolution":9.543951988220215},{"elevation":17.12937927246094,"location":{"lat":-37.8172789,"lng":144.997071},"resolution":9.543951988220215},{"elevation":17.12937927246094,"location":{"lat":-37.8172789,"lng":144.997071},"resolution":9.543951988220215},{"elevation":21.96443176269531,"location":{"lat":-37.8183266,"lng":144.9969005},"resolution":9.543951988220215},{"elevation":21.96443176269531,"location":{"lat":-37.8183266,"lng":144.9969005},"resolution":9.543951988220215},{"elevation":28.51251029968262,"location":{"lat":-37.8180674,"lng":144.9946467},"resolution":9.543951988220215},{"elevation":28.51251029968262,"location":{"lat":-37.8180674,"lng":144.9946467},"resolution":9.543951988220215},{"elevation":25.13689041137695,"location":{"lat":-37.819659,"lng":144.9943308},"resolution":9.543951988220215},{"elevation":25.13689041137695,"location":{"lat":-37.819659,"lng":144.9943308},"resolution":9.543951988220215},{"elevation":28.46485137939453,"location":{"lat":-37.8199945,"lng":144.9968204},"resolution":9.543951988220215},{"elevation":28.46485137939453,"location":{"lat":-37.8199945,"lng":144.9968204},"resolution":9.543951988220215},{"elevation":29.19716262817383,"location":{"lat":-37.8207433,"lng":144.9967928},"resolution":9.543951988220215},{"elevation":29.19716262817383,"location":{"lat":-37.8207433,"lng":144.9967928},"resolution":9.543951988220215},{"elevation":25.90586090087891,"location":{"lat":-37.8209799,"lng":144.9987558},"resolution":9.543951988220215},{"elevation":25.90586090087891,"location":{"lat":-37.8209799,"lng":144.9987558},"resolution":9.543951988220215},{"elevation":10.29346084594727,"location":{"lat":-37.8286912,"lng":144.9973902},"resolution":9.543951988220215},{"elevation":10.29346084594727,"location":{"lat":-37.8286912,"lng":144.9973902},"resolution":9.543951988220215},{"elevation":11.15404796600342,"location":{"lat":-37.8287644,"lng":144.9980297},"resolution":9.543951988220215}],"status":"OK"}"""

  override def request(url: String): Either[String, String] = Right(response)
}