package com.example.demo;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

//@RestController
//public class HeloYuriko {
//
//	@RequestMapping(value="/")
//	public String index() {
//		return "HeloYuriko";
//	}
//}
@Controller //htmlを参照してページをつくる
public class HeloYuriko{

	@RequestMapping(value="/",method=RequestMethod.GET) //ゲットメソッドなのでクレデンシャル情報も載っちゃう？
	public ModelAndView index(ModelAndView mav) { //モデル＆ビュークラス型のmav変数をインデックスmethodの引数に。
		mav.setViewName("index"); //"インデックス"ってなに？indexなんて表示しないよね。setViewName調べる！→index.htmlを参照する。
		mav.addObject("msg","フォームを送信してください");
		return mav;
	}

	@RequestMapping(value="/",method=RequestMethod.POST)
	public ModelAndView send(@RequestParam("text1")String str, ModelAndView mav) {
		mav.addObject("msg","こんにちは、" + str + "さん");
		mav.addObject("value",str);
		mav.setViewName("index");
		return mav;
	}


	@RequestMapping(value="/",method=RequestMethod.POST) //引数をあたえてJavaを動かす？
	public ModelAndView send( //sendメソッド調べてみる。
			@RequestParam(value="check1",required=false)boolean check1, //required=falseを書いておけば選択なくても例外おこらない☆
			@RequestParam(value="radio1",required=false)String radio1,
			@RequestParam(value="select1",required=false)String select1,
			@RequestParam(value="select21",required=false)String[] select2,
			ModelAndView mav) {

	String res ="";
	try {
		res = "check:" + check1 + "radio:" + radio1 + "select:" + select1 + "\nselect2:";
		}
	catch (NullPointerException e) {}

	try {
		res = res + select2[0];
		for(int i=1; i<select2.length; i++)
			res = res + ","  + select2[i];
		}
	catch(NullPointerException e) {
		res = res + "null";
	}
	mav.addObject("msg",res);
	mav.setViewName("index");
	return mav;
	}
}
