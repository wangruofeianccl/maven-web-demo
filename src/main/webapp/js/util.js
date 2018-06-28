/**
 * js公共方法定义
 */
var Util = {};
/**
 * 生成32位的UUID
 */
Util.nextUUID = function() {
	var len = 32;
	var radix = 16;
	var chars = '0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz'.split('');
	var uuid = [],i;
	radix = radix || chars.length;
	if(len){
		for(i = 0; i < len; i++)
			uuid[i] = chars[0|Math.random()*radix];
	} else {
		var r;
		uuid[8] = uuid[13] = uuid[18] = uuid[23] = '-';
		uuid[14] = '4';
		for(i = 0; i < 36; i++) {
			if(!uuid[i]) {
				r = 0|Math.random()*16;
				uuid[i] = chars[(i==19) ? (r&0x3)|0x8:r];
			}
		}
	}
	return uuid.join('');
}
/**
 * 返回格式：2016-11-20 17:23:40
 */
Util.now = function() {
	var d = new Date();
	return d.getFullYear() + "-" + Util.roize(d.getMonth() + 1) + "-" + Util.roize(d.getDate()) + " " + Util.roize(d.getHours()) + ":" + Util.roize(d.getMinutes()) + ":" + Util.roize(d.getSeconds());
}
Util.roize = function(v) {
	//只有一个长度时，前面加0
	v = v.toString();
	if(v.length == 1) {
		v = "0" + v
	}
	return v;
}

Util.getTimeStamp = function() {
	var now = new Date();
	var timestamp = now.getFullYear() + '' + ((now.getMonth() + 1) >= 10 ? "" + (now.getMonth() + 1) : "0" + (now.getMonth() + 1)) + (now.getDate() >= 10 ? now.getDate() : "0" + now.getDate()) + (now.getHours() >= 10 ? now.getHours() : "0" + now.getHours()) + (now.getMinutes() >= 10 ? now.getMinutes() : "0" + now.getMinutes()) + (now.getSeconds() >= 10 ? now.getSeconds() : "0" + now.getSeconds());
	return timestamp;
}
/**
 * 参数为格式如：20161128094530,返回时间简短格式的字符，格式如：几时几分或昨天几时几分或月日几时几分或年月日几时几分
 * @param {String} d
 */
Util.brieflyLongDate = function(d) {
	var now = new Date();
	var d1 = now.getFullYear() + Util.roize(now.getMonth() + 1) + Util.roize(now.getDate() - 1);
	var d2 = d1 + "235959";
	var ret = "";
	// 当天以内
	if(d > d2) {
		// 获取小时和分
		ret = d.substr(8, 4);
		ret = ret.substr(0, 2) + ":" + ret.substr(2, 2);
		return ret;
	}
	// 昨天以内
	d1 = now.getFullYear() + Util.roize(now.getMonth() + 1) + Util.roize(now.getDate() - 2);
	d2 = d1 + "235959";
	if(d > d2) {
		// 获取小时和分
		ret = d.substr(8, 4);
		ret = "昨天" + ret.substr(0, 2) + ":" + ret.substr(2, 2);
		return ret;
	}
	// 当年以内
	d1 = now.getFullYear() - 1;
	d2 = d1 + "1231235959";
	if(d > d2) {
		// 获取小时和分
		ret = d.substr(4, 8);
		ret = ret.substr(0, 2) + "月" + ret.substr(2, 2) + "日" + ret.substr(4, 2) + ":" + ret.substr(6, 2);
		return ret;
	} else {
		// 去年或更久的时间
		ret = d.substr(0, 12);
		ret = ret.substr(0, 4) + "年" + ret.substr(4, 2) + "月" + ret.substr(6, 2) + "日" + ret.substr(8, 2) + ":" + ret.substr(10, 2);
		return ret;
	}
}
/**
 * 参数为格式如：20161128094530,返回时间简短格式的字符，格式如：几时几分或昨天或月日或年月日
 * @param {String} d
 */
Util.brieflyShortDate = function(d) {
	var now = new Date();
	var d1 = now.getFullYear() + Util.roize(now.getMonth() + 1) + Util.roize(now.getDate() - 1);
	var d2 = d1 + "235959";
	var ret = "";
	// 当天以内
	if(d > d2) {
		// 获取小时和分
		ret = d.substr(8, 4);
		ret = ret.substr(0, 2) + ":" + ret.substr(2, 2);
		return ret;
	}
	// 昨天以内
	d1 = now.getFullYear() + Util.roize(now.getMonth() + 1) + Util.roize(now.getDate() - 2);
	d2 = d1 + "235959";
	if(d > d2) {
		ret = "昨天";
		return ret;
	}
	// 当年以内
	d1 = now.getFullYear() - 1;
	d2 = d1 + "1231235959";
	if(d > d2) {
		// 获取小时和分
		ret = d.substr(4, 4);
		ret = ret.substr(0, 2) + "月" + ret.substr(2, 2) + "日";
		return ret;
	} else {
		// 去年或更久的时间
		ret = d.substr(0, 8);
		ret = ret.substr(0, 4) + "年" + ret.substr(4, 2) + "月" + ret.substr(6, 2) + "日";
		return ret;
	}
}

// html模板代码替换
Util.formatTemplate = function(dta, tmpl) {
    var format = {
        name: function(x) {
            return x;
        }
    };  
    return tmpl.replace(/{(\w+)}/g, function(m1, m2) {
        if (!m2)
            return "";
        return (format && format[m2]) ? format[m2](dta[m2]) : dta[m2];
    });
}
// 大于某个数量的字符的截取处理
Util.spilthReplace = function(val, len) {
	if(val.length > len) {
		val = val.substr(0, len) + "...";
	}
	return val;
}
// 复制内容到剪贴板
Util.copyToClip = function(val) {
	if(mui.os.ios) {
		var UIPasteboard = plus.ios.importClass("UIPasteboard");
		var generalPasteboard = UIPasteboard.generalPasteboard();
		// 设置/获取文本内容
//		generalPasteboard.setValueforPasteboardType("testValue", "public.utf8-plain-text");
//		var value = generalPasteboard.valueForPasteboardType("public.utf8-plain-text");
		generalPasteboard.plusCallMethod({setValue: val, forPasteboardType:"public.utf8-plain-text"});
		generalPasteboard.plusCallMethod({valueForPasteboardType:"public.utf8-plain-text"});
	} else {
		var Context = plus.android.importClass("android.content.Context");
		var main = plus.android.runtimeMainActivity();
		var clip = main.getSystemService(Context.CLIPBOARD_SERVICE);
		plus.android.invoke(clip, "setText", val);
	}
}