$(document).ready(function(){
    $(".input1").each(function(){
        $(this).focus(function(){
           // $(this).prop('placeholder','');
           $(this).attr('placeholder','');
        });
    });
    $(".input1").each(function(){
        $(this).blur(function(){
           // $(this).prop('placeholder','');
           //$("input:first").attr('placeholder',"管理登录");
           $("input[type='text']").attr('placeholder',"管理登录");
           $("input[type='password']").attr('placeholder',"请输入密码");
        });
    });

    //菜单收缩展开
    $('.nav').on('click',function()
        {
            if (!$('.nav').hasClass('nav-item'))
            {

                if ($(this).next().css('display') == "none") 
                {
                    $(".nav").children("ul").slideUp(300);
                    $(this).next("ul").slideDown(300);
                    $(this).parent('li').addClass('nav-show').
                    /*removeClass移除*/
                    /*siblings()表示查找每个li元素的所有类名为 "selected" 的
                    所有同胞元素*/
                    siblings('li').removeClass('nav-show');
                    
                }
                else
                {
                    //收缩已展开
                    /*通过使用滑动效果，如果元素已显示出来,
                    隐藏被选元素，*/
                    $(this).next('ul').slideUp(300);
                    $('.nav.nav-show').removeClass('nav-show');
                    $('ul>li').css('display', 'block');
                }
            }
        });
    $('#mini').on('click',function()
        {
            if (!$('.nav').hasClass('nav-mini')) 
            {
                $('.nav.nav-show').removeClass('nav-show');
                $('.nav').children('ul').removeAttr('style');
                $('.nav').addClass('nav-mini');
            }
            else
            {
                $('.nav').removeClass('nav-mini');
                $('ul.ztree').css('display', 'none');
            }
        });
        //插件
        var zTreeObj;
   // zTree 的参数配置，深入使用请参考 API 文档（setting 配置详解）
   var setting={
            view: {
                dblClickExpand: true,//双击节点时，是否自动展开父节点的标识
                showLine: true,//是否显示节点之间的连线
                fontCss:{color:'white','font-weight':'bold'},//字体样式函数
                selectedMulti: false ,//设置是否允许同时选中多个节点
                showIcon:true,
                //添加新的控件
                addDiyDom:link
              },
              data: {
                simpleData: {//简单数据模式
                  enable:true,
                  idKey: "id",
                  pIdKey: "pId",
                  rootPId:null
                }
              },
              callback: {
                beforeClick: function(treeId, treeNode) {
                  zTree = $.fn.zTree.getZTreeObj("#treeDemo");
                  if (treeNode.isParent) {
                    zTree.expandNode(treeNode);//如果是父节点，则展开该节点
                  }else{
                    zTree.checkNode(treeNode, !treeNode.checked, true, true);//单击勾选，再次单击取消勾选
                  }
                }
            },
            async: {
                enable: true,
                url:"findAccountJSON",
            }
        };

        
   // zTree 的数据属性，深入使用请参考 API 文档（zTreeNode 节点数据详解）
   var zNodes = [
    {name:"员工管理系统", open:true, children:[
        {name:"人力资源管理系统", open:true, children:[
            {name:"部门管理"}, {name:"员工管理"},{name:"返回主页"}]},
   /*{name:"员工管理系统1", open:true, children:[
       {name:"部门管理1"}, {name:"员工管理1"}]}*/
   ]},
];
   $(document).ready(function(){
      zTreeObj = $.fn.zTree.init($("#treeDemo"), setting, zNodes);
   });
   
   
    //实现跳转页面
    function link(){
        $("#treeDemo_3_a").click(function(){
            $("#treeDemo_3_a").attr("href","/EmpManager/department_findAll.action");
            $("#treeDemo_3_a").attr("target","_self");
        });
        $("#treeDemo_4_a").click(function(){
            $("#treeDemo_4_a").attr("href","/EmpManager/employee_findAll.action");
            $("#treeDemo_4_a").attr("target","_self");
        });
        $("#treeDemo_5_a").click(function(){
            $("#treeDemo_5_a").attr("href","index.jsp");
            $("#treeDemo_5_a").attr("target","_self");
        });

        
    };   	
    	//添加部门里的判断
    $(function(){
 		$(".button").on('click',function(){
    		if($("#saveform_dname").val()==""||$("#saveform_ddesc").val()==""){
    			alert("您输入的不能为空");
    			$(".change").attr("href","#");				
    		}else{
    			$(".change").attr("href","javascript:document.getElementById('saveform').submit()");
    		}
    	});
 	});
    
    //添加员工里的判断
    $(function(){
    	console.log($("input[type='radio']"));
    	$(".button-add").click(function(){
  		if($("#saveform_ename").val()==""||$("#saveform_username").val()==""||$("#saveform_password").val()==""||$("#saveform_birthday").val()==""
   			||$("#saveform_joinDate").val()==""||$("#saveform_department_did").val()==""||$("#saveform_eno").val()==""
   			||$("input:radio[name='sex']:checked").val()==null
   		){
   			alert("您输入的不能为空");
   			return false;
   		}else{
   			$(".change-add").attr("href","javascript:document.getElementById('saveform').submit()");
    		}
    		
    	});
    });
 	
 	//添加员工用户名和密码为空
 	$(function(){
 		$(".clear input").val("");
 		$("#saveform_birthday").attr("title","时间格式应为:xxxx-x-x");
 	});
    
    $(function () {

        $("#saveform_birthday").calendar({

            controlId: "divDate",                                 // 弹出的日期控件ID，默认: $(this).attr("id") + "Calendar"

            speed: 200,                                           // 三种预定速度之一的字符串("slow", "normal", or "fast")或表示动画时长的毫秒数值(如：1000),默认：200

            complement: true,                                     // 是否显示日期或年空白处的前后月的补充,默认：true

            readonly: true,                                       // 目标对象是否设为只读，默认：true

            upperLimit: new Date(),                               // 日期上限，默认：NaN(不限制)

            lowerLimit: new Date("2011/01/01"),                   // 日期下限，默认：NaN(不限制)

            callback: function () {                               // 点击选择日期后的回调函数

                //alert("您选择的日期是：" + $("#saveform_birthday").val());

            }

        });

        $("#saveform_joinDate").calendar();

    });
 

});