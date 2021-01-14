package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import repositories.MyDataRepository;

//@Controller
//public class HeloYuriko {
//
//	@RequestMapping("/{num}")
//	public ModelAndView index(@PathVariable int num, ModelAndView mav) {
//		int res  = 0;
//		for(int i=1; i<=num; i++)
//			res += i;
//		mav.addObject("msg", "total:" + res);
//      mav.setViewName("HeloYuriko");
//		return mav;
//	}
//}

@Controller
public class HeloYuriko{

//	@RequestMapping(value="/",method=RequestMethod.GET) //先にPOSTを書いてもGETが先に処理される。ゲットメソッドなのでクレデンシャル情報も載っちゃう？
//	public ModelAndView index(ModelAndView mav) { //モデル＆ビュークラス型のmav変数をインデックスmethodの引数に。
//		mav.addObject("msg","名前を入力して送信してください");
//		mav.setViewName("HeloYuriko"); //""内はhtmlファイルの名称
//		return mav;
//	}
//
//	@RequestMapping(value="/",method=RequestMethod.POST)
//	public ModelAndView send(@RequestParam("text1")String str, ModelAndView mv) {
//		mv.addObject("msg","こんにちは、" + str + "さん");
//		mv.addObject("value",str);
//		mv.setViewName("HeloYuriko");
//		return mv;
//	}
//
//	@RequestMapping(value="/",method=RequestMethod.POST) //引数をあたえてJavaを動かす？
//	public ModelAndView send( //sendメソッド調べてみる。
//			@RequestParam(value="check1",required=false)boolean check1, //required=falseを書いておけば選択なくても例外おこらない☆
//			@RequestParam(value="radio1",required=false)String radio1,
//			@RequestParam(value="select1",required=false)String select1,
//			@RequestParam(value="select2",required=false)String[] select2,
//			ModelAndView av) {
//
//	String res ="";
//	try {
//		res = "check:" + check1 + " radio:" + radio1 + " select:" + select1 + " \nselect2:";
//		}
//	catch (NullPointerException e) {}
//
//	try {
//		res += select2[0];
//		for(int i=1; i<select2.length; i++)
//			res += ","  + select2[i];
//		}
//	catch(NullPointerException e) {
//		res += "null";
//	}
//	av.addObject("tyantyan",res);
//	av.setViewName("HeloYuriko");
//	return av;
//	}

//@RequestMapping("/") //WEBページのフォワードとリダイレクトの挙動確認プログラム（以下３つのリクマップ）
//public ModelAndView index(ModelAndView mav) {
//	mav.setViewName("HeloYuriko");
//	return mav;
//}
//
//@RequestMapping("/other")
//public String other() {
//	return "redirect:/";
//}
//
//@RequestMapping("/home")
//public String home() {
//	return "forward:/";

//	@RequestMapping("/")
//	public ModelAndView index(ModelAndView mav) {
//		mav.setViewName("HeloYuriko");
//		ArrayList<String[]> data = new ArrayList<String[]>();
//		data.add(new String[] {"taro","taro@yamada","000-0000-0000"});
//		data.add(new String[] {"taro","hanako@yamada","000-0000-0000"});
//		data.add(new String[] {"taro","satie@yamada","000-0000-0000"});
//		mav.addObject("data",data);
//		return mav;
//	}

	@Autowired
	MyDataRepository repository;
	//このアノテーションはアプリに用意されているBeanオブジェクト（springMVCによって自動的にインスタンスが作成され、
		//アプリ内で利用可能になったもの）に関連付けを行う。
		//これにより、MyDataRepositoryインスタンスが自動的にrepositoryフィールドに設定される。

	@RequestMapping("/")
	public ModelAndView index(ModelAndView mav) { //モデルアンドビュークラス型の変数mavを用意してビューへデータを渡す。
		mav.setViewName("HeloYuriko"); //ビューの名前をmavにin。
		mav.addObject("msg","this is sample content"); //メッセージオブジェクトをmavに追加。
		Iterable<MyData> list = repository.findAll(); //Interable<MyData>型の変数listに、repositoryのエンティティを格納。
		mav.addObject("data",list);
		return mav;
	}
}
