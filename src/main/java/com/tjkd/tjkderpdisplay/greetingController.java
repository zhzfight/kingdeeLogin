package com.tjkd.tjkderpdisplay;

import okhttp3.*;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.io.IOException;

@Controller
public class greetingController {


    private String urlPrefix = "http://localhost:8080/ierp/accessTokenLogin.do?access_token=";
    private String postfix = "&redirect=http://127.0.0.1:8080/ierp/index.html?formId=pc_main_console&appNumber=";
    private String getAppToken = "http://localhost:8080/ierp/api/getAppToken.do";
    private String getAccessToken = "http://localhost:8080/ierp/api/login.do";
    public static final MediaType JSON
            = MediaType.get("application/json; charset=utf-8");
    private OkHttpClient client = new OkHttpClient();

    private String post(String url, String json) throws IOException {
        RequestBody body = RequestBody.create(JSON, json);
        Request request = new Request.Builder()
                .url(url)
                .post(body)
                .build();
        try (Response response = client.newCall(request).execute()) {
            return response.body().string();
        }
    }


    @GetMapping("/index")
    public String index() throws IOException{
        return "index";
    }

    @GetMapping("/author")
    public String author() throws IOException{
       return "authorIntro";
    }

    @GetMapping("/work")
    public String work(Model model)throws IOException{



        return "/work";
    }




    @GetMapping("/greeting")
    public String greeting(Model model) throws IOException {
        /*
        appTokenDAO appTokenDAO = new appTokenDAO();
        appTokenDAO.setAppId("TJKD");
        appTokenDAO.setAppSecuret("123456789123456789");
        appTokenDAO.setTenantid("TJ001");


        String appTokenResponseBody = post(getAppToken, com.alibaba.fastjson.JSON.toJSONString(appTokenDAO));
        appTokenResponse appTokenRes = com.alibaba.fastjson.JSON.parseObject(appTokenResponseBody, appTokenResponse.class);

        System.out.println(appTokenResponseBody);
        accessTokenDAO accessTokenDAO = new accessTokenDAO();
        accessTokenDAO.setUser("15622394658");
        accessTokenDAO.setApptoken(appTokenRes.getData().getApp_token());
        accessTokenDAO.setTenantid("TJ001");
        //System.out.println(appTokenRes.getData().getApp_token());
        String accessTokenResponseBody = post(getAccessToken, com.alibaba.fastjson.JSON.toJSONString(accessTokenDAO));
        //System.out.println(accessTokenResponseBody);
        accessTokenResponse accessTokenRes = com.alibaba.fastjson.JSON.parseObject(accessTokenResponseBody, accessTokenResponse.class);
        //System.out.println(accessTokenRes.getData().getAccess_token());

        //caiwu
        String gl = urlPrefix + accessTokenRes.getData().getAccess_token() + postfix + "gl";
        String fa = urlPrefix + accessTokenRes.getData().getAccess_token() + postfix + "fa";
        String em = urlPrefix + accessTokenRes.getData().getAccess_token() + postfix + "em";
        String cas = urlPrefix + accessTokenRes.getData().getAccess_token() + postfix + "cas";
        String cbei = urlPrefix + accessTokenRes.getData().getAccess_token() + postfix + "cbei";
        String ar = urlPrefix + accessTokenRes.getData().getAccess_token() + postfix + "ar";
        String ap = urlPrefix + accessTokenRes.getData().getAccess_token() + postfix + "ap";
        String cal = urlPrefix + accessTokenRes.getData().getAccess_token() + postfix + "cal";
        String calx = urlPrefix + accessTokenRes.getData().getAccess_token() + postfix + "calx";
        String rpt = urlPrefix + accessTokenRes.getData().getAccess_token() + postfix + "rpt";
        String cm = urlPrefix + accessTokenRes.getData().getAccess_token() + postfix + "cm";
        String iep = urlPrefix + accessTokenRes.getData().getAccess_token() + postfix + "iep";
        String aifs = urlPrefix + accessTokenRes.getData().getAccess_token() + postfix + "aifs";
        String fr = urlPrefix + accessTokenRes.getData().getAccess_token() + postfix + "fr";
        String ssc = urlPrefix + accessTokenRes.getData().getAccess_token() + postfix + "ssc";
        String som = urlPrefix + accessTokenRes.getData().getAccess_token() + postfix + "som";
        String ai = urlPrefix + accessTokenRes.getData().getAccess_token() + postfix + "ai";
        String er = urlPrefix + accessTokenRes.getData().getAccess_token() + postfix + "er";
        String pa = urlPrefix + accessTokenRes.getData().getAccess_token() + postfix + "pa";
        String aef = urlPrefix + accessTokenRes.getData().getAccess_token() + postfix + "aef";
        String fea = urlPrefix + accessTokenRes.getData().getAccess_token() + postfix + "fea";
        String fcm = urlPrefix + accessTokenRes.getData().getAccess_token() + postfix + "fcm";
        String fibd = urlPrefix + accessTokenRes.getData().getAccess_token() + postfix + "fibd";
        model.addAttribute("caiwu", gl);

        //zhizao
        String pdm = urlPrefix + accessTokenRes.getData().getAccess_token() + postfix + "pdm";
        String om = urlPrefix + accessTokenRes.getData().getAccess_token() + postfix + "om";
        String mds = urlPrefix + accessTokenRes.getData().getAccess_token() + postfix + "mds";
        String mrp = urlPrefix + accessTokenRes.getData().getAccess_token() + postfix + "mrp";
        String pom = urlPrefix + accessTokenRes.getData().getAccess_token() + postfix + "pom";
        String sfc = urlPrefix + accessTokenRes.getData().getAccess_token() + postfix + "sfc";
        String opm = urlPrefix + accessTokenRes.getData().getAccess_token() + postfix + "opm";
        String phm = urlPrefix + accessTokenRes.getData().getAccess_token() + postfix + "phm";
        String fmm = urlPrefix + accessTokenRes.getData().getAccess_token() + postfix + "fmm";

        //yuangongfuwu
        String tra = urlPrefix + accessTokenRes.getData().getAccess_token() + postfix + "tra";
        String exp = urlPrefix + accessTokenRes.getData().getAccess_token() + postfix + "exp";
        String kdem = urlPrefix + accessTokenRes.getData().getAccess_token() + postfix + "kdem";
        String fap = urlPrefix + accessTokenRes.getData().getAccess_token() + postfix + "fap";
        String dhc = urlPrefix + accessTokenRes.getData().getAccess_token() + postfix + "dhc";

        //gongyinglianyun
        String pmp = urlPrefix + accessTokenRes.getData().getAccess_token() + postfix + "pmp";
        String pm = urlPrefix + accessTokenRes.getData().getAccess_token() + postfix + "pm";
        String vmi = urlPrefix + accessTokenRes.getData().getAccess_token() + postfix + "vmi";
        String pms = urlPrefix + accessTokenRes.getData().getAccess_token() + postfix + "pms";
        String sm = urlPrefix + accessTokenRes.getData().getAccess_token() + postfix + "sm";
        String ccm = urlPrefix + accessTokenRes.getData().getAccess_token() + postfix + "ccm";
        String im = urlPrefix + accessTokenRes.getData().getAccess_token() + postfix + "im";
        String ism = urlPrefix + accessTokenRes.getData().getAccess_token() + postfix + "ism";
        String scmdi = urlPrefix + accessTokenRes.getData().getAccess_token() + postfix + "scmdi";
        String sbs = urlPrefix + accessTokenRes.getData().getAccess_token() + postfix + "sbs";
        String plat = urlPrefix + accessTokenRes.getData().getAccess_token() + postfix + "plat";

        //jixiaoyun
        String bgm = urlPrefix + accessTokenRes.getData().getAccess_token() + postfix + "bgm";
        String eb = urlPrefix + accessTokenRes.getData().getAccess_token() + postfix + "eb";
        String bgmd = urlPrefix + accessTokenRes.getData().getAccess_token() + postfix + "bgmd";
        String bgc = urlPrefix + accessTokenRes.getData().getAccess_token() + postfix + "bgc";
        String bgbd = urlPrefix + accessTokenRes.getData().getAccess_token() + postfix + "bgbd";


         */
        return "greeting";
    }

    private String cosmicAuth() throws IOException {
        appTokenDAO appTokenDAO = new appTokenDAO();
        appTokenDAO.setAppId("tjindex001");
        appTokenDAO.setAppSecuret("123456789123456789");
        appTokenDAO.setTenantid("cosmic-simple");
        String appTokenResponseBody = post(getAppToken, com.alibaba.fastjson.JSON.toJSONString(appTokenDAO));
        appTokenResponse appTokenRes = com.alibaba.fastjson.JSON.parseObject(appTokenResponseBody, appTokenResponse.class);
        accessTokenDAO accessTokenDAO = new accessTokenDAO();
        accessTokenDAO.setUser("15622394658");
        accessTokenDAO.setApptoken(appTokenRes.getData().getApp_token());
        accessTokenDAO.setTenantid("cosmic-simple");
        String accessTokenResponseBody = post(getAccessToken, com.alibaba.fastjson.JSON.toJSONString(accessTokenDAO));
        accessTokenResponse accessTokenRes = com.alibaba.fastjson.JSON.parseObject(accessTokenResponseBody, accessTokenResponse.class);
        //System.out.println(accessTokenRes.getData().getAccess_token());
        return accessTokenRes.getData().getAccess_token();
    }


    @GetMapping("/caiwu")
    public String caiwu(Model model) throws IOException {
        String accessToken = cosmicAuth();
        String urlPrefix = "http://localhost:8080/ierp/accessTokenLogin.do?access_token=";
        String postfix = "&redirect=http://127.0.0.1:8080/ierp/index.html?formId=pc_main_console&appNumber=";
        String gl = urlPrefix + accessToken + postfix + "gl";
        String fa = urlPrefix + accessToken + postfix + "fa";
        String em = urlPrefix + accessToken + postfix + "em";
        String cas = urlPrefix + accessToken + postfix + "cas";
        String cbei = urlPrefix + accessToken + postfix + "cbei";
        String ar = urlPrefix + accessToken + postfix + "ar";
        String ap = urlPrefix + accessToken + postfix + "ap";
        /*
        String cal=urlPrefix+accessToken+postfix+"cal";
        String calx=urlPrefix+accessToken+postfix+"calx";
        String rpt=urlPrefix+accessToken+postfix+"rpt";
        String cm=urlPrefix+accessToken+postfix+"cm";
        String iep=urlPrefix+accessToken+postfix+"iep";
        String aifs=urlPrefix+accessToken+postfix+"aifs";
        String fr=urlPrefix+accessToken+postfix+"fr";
        String ssc=urlPrefix+accessToken+postfix+"ssc";
        String som=urlPrefix+accessToken+postfix+"som";
        String ai=urlPrefix+accessToken+postfix+"ai";
        String er=urlPrefix+accessToken+postfix+"er";
        String pa=urlPrefix+accessToken+postfix+"pa";
        String aef=urlPrefix+accessToken+postfix+"aef";
        String fea=urlPrefix+accessToken+postfix+"fea";
        String fcm=urlPrefix+accessToken+postfix+"fcm";
        String fibd=urlPrefix+accessToken+postfix+"fibd";
        */

        model.addAttribute("gl", gl);
        model.addAttribute("fa", fa);
        model.addAttribute("em", em);
        model.addAttribute("cas", cas);
        model.addAttribute("cbei", cbei);
        model.addAttribute("ar", ar);
        model.addAttribute("ap", ap);
        return "caiwu";
    }

    @GetMapping("/zhizao")
    public String zhizao(Model model) throws IOException {
        String accessToken = cosmicAuth();
        String pdm = urlPrefix + accessToken + postfix + "pdm";
        String om = urlPrefix + accessToken + postfix + "om";
        String mds = urlPrefix + accessToken + postfix + "mds";
        String mrp = urlPrefix + accessToken + postfix + "mrp";
        String pom = urlPrefix + accessToken + postfix + "pom";
        String sfc = urlPrefix + accessToken + postfix + "sfc";
        String opm = urlPrefix + accessToken + postfix + "opm";
        /*
        String phm=urlPrefix+accessToken+postfix+"phm";
        String fmm=urlPrefix+accessToken+postfix+"fmm";

         */
        model.addAttribute("pdm", pdm);
        model.addAttribute("om", om);
        model.addAttribute("mds", mds);
        model.addAttribute("mrp", mrp);
        model.addAttribute("pom", pom);
        model.addAttribute("sfc", sfc);
        model.addAttribute("opm", opm);
        return "zhizao";
    }

    @GetMapping("/yuangongfuwu")
    public String yuangongfuwu(Model model) throws IOException {
        String accessToken = cosmicAuth();
        String tra = urlPrefix + accessToken + postfix + "tra";
        String exp = urlPrefix + accessToken + postfix + "exp";
        String kdem = urlPrefix + accessToken + postfix + "kdem";
        String fap = urlPrefix + accessToken + postfix + "fap";
        String dhc = urlPrefix + accessToken + postfix + "dhc";

        model.addAttribute("tra", tra);
        model.addAttribute("exp", exp);
        model.addAttribute("kdem", kdem);
        model.addAttribute("fap", fap);
        model.addAttribute("dhc", dhc);
        return "yuangongfuwu";
    }

    @GetMapping("/gongyinglian")
    public String gongyinglian(Model model) throws IOException {
        String accessToken = cosmicAuth();
        String pmp = urlPrefix + accessToken + postfix + "pmp";
        String pm = urlPrefix + accessToken + postfix + "pm";
        String vmi = urlPrefix + accessToken + postfix + "vmi";
        String pms = urlPrefix + accessToken + postfix + "pms";
        String sm = urlPrefix + accessToken + postfix + "sm";
        String ccm = urlPrefix + accessToken + postfix + "ccm";
        String im = urlPrefix + accessToken + postfix + "im";
        /*
        String ism=urlPrefix+accessToken+postfix+"ism";
        String scmdi=urlPrefix+accessToken+postfix+"scmdi";
        String sbs=urlPrefix+accessToken+postfix+"sbs";
        String plat=urlPrefix+accessToken+postfix+"plat";

         */
        model.addAttribute("pmp", pmp);
        model.addAttribute("pm", pm);
        model.addAttribute("vmi", vmi);
        model.addAttribute("pms", pms);
        model.addAttribute("sm", sm);
        model.addAttribute("ccm", ccm);
        model.addAttribute("im", im);

        return "gongyinglian";
    }

    @GetMapping("/jixiao")
    public String jixiao(Model model) throws IOException {
        String accessToken = cosmicAuth();
        String bgm = urlPrefix + accessToken + postfix + "bgm";
        String eb = urlPrefix + accessToken + postfix + "eb";
        String bgmd = urlPrefix + accessToken + postfix + "bgmd";
        String bgc = urlPrefix + accessToken + postfix + "bgc";
        String bgbd = urlPrefix + accessToken + postfix + "bgbd";

        model.addAttribute("bgm", bgm);
        model.addAttribute("eb", eb);
        model.addAttribute("bgmd", bgmd);
        model.addAttribute("bgc", bgc);
        model.addAttribute("bgbd", bgbd);
        return "jixiao";

    }
}
