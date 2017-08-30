package com.miguan.yjy.model.constant;

import com.miguan.yjy.model.bean.CityItem;
import com.miguan.yjy.module.user.widget.ContactItemInterface;
import com.miguan.yjy.module.user.widget.pinyin.PinYin;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

/**
 * 357个中国城市
 * @author cjh
 * @since 2016年08月16日 15:20:32
 */
public class CityData
{
//	'北京','上海','广州','深圳','厦门','福州','杭州','重庆','武汉','天津','南京','泉州';
//	'上海','北京','杭州','广州','南京','苏州','深圳','成都','重庆','天津','宁波','扬州','无锡','福州','厦门','武汉','西安','沈阳','大连','青岛','济南','海口','石家庄','唐山','秦皇岛','邯郸','邢台','保定','张家口','承德','沧州','廊坊','衡水','太原','大同','阳泉','长治','晋城','朔州','晋中','运城','忻州','临汾','吕梁','呼和浩特','包头','乌海','赤峰','通辽','鄂尔多斯','呼伦贝尔','兴安盟','锡林郭勒','乌兰察布','巴彦淖尔','阿拉善','鞍山','抚顺','本溪','丹东','锦州','营口','阜新','辽阳','盘锦','铁岭','朝阳','葫芦岛','长春','吉林','四平','辽源','通化','白山','松原','白城','延边','哈尔滨','齐齐哈尔','鸡西','鹤岗','双鸭山','大庆','伊春','佳木斯','七台河','牡丹江','黑河','绥化','大兴安岭','徐州','常州','南通','连云港','淮安','盐城','镇江','泰州','宿迁','温州','嘉兴','湖州','绍兴','金华','衢州','舟山','台州','丽水','合肥','芜湖','蚌埠','淮南','马鞍山','淮北','铜陵','安庆','黄山','滁州','阜阳','宿州','六安','亳州','池州','宣城','莆田','三明','泉州','漳州','南平','龙岩','宁德','南昌','景德镇','萍乡','九江','新余','鹰潭','赣州','吉安','宜春','抚州','上饶','淄博','枣庄','东营','烟台','潍坊','济宁','泰安','威海','日照','莱芜','临沂','德州','聊城','滨州','菏泽','郑州','开封','洛阳','平顶山','安阳','鹤壁','新乡','焦作','濮阳','许昌','漯河','三门峡','南阳','商丘','信阳','周口','驻马店','黄石','十堰','宜昌','襄阳','鄂州','荆门','孝感','荆州','黄冈','咸宁','随州','恩施州','仙桃','潜江','天门','株洲','湘潭','衡阳','邵阳','岳阳','常德','张家界','益阳','郴州','永州','怀化','娄底','湘西','韶关','珠海','汕头','佛山','江门','湛江','茂名','肇庆','惠州','梅州','汕尾','河源','阳江','清远','东莞','中山','潮州','揭阳','云浮','南宁','柳州','桂林','梧州','北海','防城港','钦州','贵港','玉林','百色','贺州','河池','自贡','攀枝花','泸州','德阳','绵阳','广元','遂宁','内江','乐山','南充','眉山','宜宾','广安','达州','雅安','巴中','资阳','阿坝','甘孜州','凉山','贵阳','六盘水','遵义','安顺','铜仁地区','黔西南','毕节地区','黔东南','黔南','昆明','曲靖','玉溪','保山','昭通','楚雄州','红河','文山州','普洱','西双版纳','大理州','德宏','丽江','怒江','迪庆','临沧','拉萨','昌都地区','山南','日喀则地区','那曲','阿里','林芝地区','铜川','宝鸡','咸阳','渭南','延安','汉中','榆林','安康','商洛','兰州','嘉峪关','金昌','白银','天水','武威','张掖','平凉','酒泉','庆阳','定西','陇南','临夏州','甘南','西宁','海东','海北','黄南','果洛','玉树','海西','银川','石嘴山','吴忠','固原','乌鲁木齐','克拉玛依','吐鲁番地区','哈密地区','昌吉州','博尔塔拉','巴音郭楞','阿克苏地区','克孜勒苏','喀什地区','和田地区','伊犁','塔城地区','阿勒泰地区','石河子','香港','澳门','长沙','三亚','中卫','儋州','保亭','昌江','澄迈县','崇左','定安县','东方','济源','来宾','乐东','陵水','琼海','神农架林区','图木舒克','屯昌县','万宁','文昌','海南州'
	static String cityJson = "{'cities':['北京','上海','广州','深圳','厦门','福州','杭州','重庆','武汉','天津','南京','泉州','甘南藏族自治州','甘孜藏族自治州','赣州市','高雄市','高雄县','固原市','广安市','广元市','广州市','贵港市','贵阳市','桂林市','果洛藏族自治州','哈尔滨市','哈密地区','海外','海北藏族自治州','海东地区','海口市','海南藏族自治州','海西蒙古族藏族自治州','邯郸市','汉中市','杭州市','合肥市','和田地区','河池市','河源市','菏泽市','贺州市','鹤壁市','鹤岗市','黑河市','衡水市','衡阳市','红河哈尼族彝族自治州','呼和浩特市','呼伦贝尔市','湖州市','葫芦岛市','花莲县','怀化市','淮安市','淮北市','淮南市','黄冈市','黄南藏族自治州','黄山市','黄石市','惠州市','无锡市','万宁市','威海市','潍坊市','渭南市','温州市','文昌市','文山壮族苗族自治州','乌海市','乌兰察布市','乌鲁木齐市','吴忠市','芜湖市','梧州市','五家渠市','五指山市','武汉市','武威市','鸡西市','基隆市','吉安市','吉林市','济南市','济宁市','济源市','佳木斯市','嘉兴市','嘉义市','嘉义县','嘉峪关市','江门市','焦作市','揭阳市','金昌市','金华市','锦州市','晋城市','晋中市','荆门市','荆州市','景德镇市','九江市','酒泉市','西安市','西宁市','西沙群岛','西双版纳傣族自治州','锡林郭勒盟','厦门市','仙桃市','咸宁市','咸阳市','香港特别行政区','湘潭市','湘西土家族苗族自治州','襄樊市','孝感市','忻州市','新乡市','新余市','新竹市','新竹县','信阳市','兴安盟','邢台市','徐州市','许昌市','宣城市','喀什地区','开封市','克拉玛依市','克孜勒苏柯尔克孜自治州','昆明市','雅安市','烟台市','延安市','延边朝鲜族自治州','盐城市','扬州市','阳江市','阳泉市','伊春市','伊犁哈萨克自治州','宜宾市','宜昌市','宜春市','宜兰县','益阳市','银川市','鹰潭市','营口市','永州市','榆林市','玉林市','玉树藏族自治州','玉溪市','岳阳市','云浮市','云林县','运城市','拉萨市','来宾市','莱芜市','兰州市','廊坊市','乐东黎族自治县','乐山市','丽江市','丽水市','连云港市','凉山彝族自治州','辽阳市','辽源市','聊城市','林芝地区','临沧市','临汾市','临高县','临夏回族自治州','临沂市','陵水黎族自治县','柳州市','六安市','六盘水市','龙岩市','陇南市','娄底市','泸州市','吕梁市','洛阳市','漯河市','枣庄市','湛江市','张家界市','张家口市','张掖市','彰化县','漳州市','昭通市','肇庆市','镇江市','郑州市','中沙群岛的岛礁及其海域','中山市','中卫市','重庆市','舟山市','周口市','株洲市','珠海市','驻马店市','资阳市','淄博市','自贡市','遵义市','马鞍山市','茂名市','眉山市','梅州市','绵阳市','苗栗县','牡丹江市','内江市','那曲地区','南昌市','南充市','南京市','南宁市','南平市','南沙群岛','南通市','南投县','南阳市','宁波市','宁德市','怒江傈僳族自治州','阿坝藏族羌族自治州','阿克苏地区','阿拉尔市','阿拉善盟','阿勒泰地区','阿里地区','安康市','安庆市','安顺市','安阳市','鞍山市','澳门特别行政区','巴彦淖尔市','巴音郭楞蒙古自治州','巴中市','白城市','白沙黎族自治县','白山市','白银市','百色市','蚌埠市','包头市','宝鸡市','保定市','保山市','保亭黎族苗族自治县','北海市','北京市','本溪市','毕节地区','滨州市','亳州市','博尔塔拉蒙古自治州','攀枝花市','盘锦市','澎湖县','平顶山市','平凉市','屏东县','萍乡市','莆田市','濮阳市','沧州市','昌都地区','昌吉回族自治州','昌江黎族自治县','长春市','长沙市','长治市','常德市','常州市','巢湖市','朝阳市','潮州市','郴州市','成都市','承德市','澄迈县','池州市','赤峰市','崇左市','滁州市','楚雄彝族自治州','七台河市','齐齐哈尔市','其他','潜江市','黔东南苗族侗族自治州','黔南布依族苗族自治州','黔西南布依族苗族自治州','钦州市','秦皇岛市','青岛市','清远市','庆阳市','琼海市','琼中黎族苗族自治县','曲靖市','衢州市','泉州市','达州市','大理白族自治州','大连市','大庆市','大同市','大兴安岭地区','丹东市','儋州市','德宏傣族景颇族自治州','德阳市','德州市','迪庆藏族自治州','定安县','定西市','东方市','东莞市','东营市','日喀则地区','日照市','鄂尔多斯市','鄂州市','恩施土家族苗族自治州','三门峡市','三明市','三亚市','山南地区','汕头市','汕尾市','商洛市','商丘市','上海市','上饶市','韶关市','邵阳市','绍兴市','深圳市','神农架林区','沈阳市','十堰市','石河子市','石家庄市','石嘴山市','双鸭山市','朔州市','思茅市','四平市','松原市','苏州市','宿迁市','宿州市','绥化市','随州市','遂宁市','防城港市','佛山市','福州市','抚顺市','抚州市','阜新市','阜阳市','塔城地区','台北市','台北县','台东县','台南市','台南县','台中市','台中县','台州市','太原市','泰安市','泰州市','唐山市','桃园县','天津市','天门市','天水市','铁岭市','通化市','通辽市','铜川市','铜陵市','铜仁地区','图木舒克市','吐鲁番地区','屯昌县']}";

	public static List<ContactItemInterface> getSampleContactList()
	{
		List<ContactItemInterface> list = new ArrayList<ContactItemInterface>();

		try
		{
			JSONObject jo1 = new JSONObject(cityJson);

			JSONArray ja1 = jo1.getJSONArray("cities");

			for(int i = 0; i < ja1.length(); i++)
			{
				String cityName = ja1.getString(i);

				list.add(new CityItem(cityName, PinYin.getPinYin(cityName)));
			}
		}
		catch (JSONException e)
		{
			e.printStackTrace();
		}
		return list;
	}

}
