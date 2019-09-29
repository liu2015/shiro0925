package com.example.demo.Utils;

import com.example.demo.entity.SysMenu;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class TreeUtils {


    public static List<SysMenu> getChildPerms(List<SysMenu> list, int parentId) {
        List<SysMenu> returnList=new ArrayList<SysMenu>();
        for (Iterator<SysMenu> iterator=list.iterator(); iterator.hasNext(); ) {
            SysMenu t=(SysMenu) iterator.next();
            // 一、根据传入的某个父节点ID,遍历该父节点的所有子节点
            if (t.getParentId() == parentId) {
                recursionFn( list, t );
                returnList.add( t );
            }
        }
        return returnList;
    }


    /**
     * 递归列表
     *
     * @param list
     * @param t
     */
    private static void recursionFn(List<SysMenu> list, SysMenu t) {
        // 得到子节点列表
        List<SysMenu> childList=getChildList( list, t );
        t.setChildren( childList );
        for (SysMenu tChild : childList) {
            if (hasChild( list, tChild )) {
                // 判断是否有子节点
                Iterator<SysMenu> it=childList.iterator();
                while (it.hasNext()) {
                    SysMenu n=(SysMenu) it.next();
                    recursionFn( list, n );
                }
            }
        }
    }


    //    获得子节点
    private static List<SysMenu> getChildList(List<SysMenu> list12, SysMenu tlist) {

        List<SysMenu> tlist1=new ArrayList<SysMenu>();
        Iterator<SysMenu> it=list12.iterator();
        while (it.hasNext()) {
            SysMenu n=(SysMenu) it.next();

            if (n.getParentId().longValue() == tlist.getMenuId().longValue()) ;
            {
                tlist1.add( n );

            }
        }


        return tlist1;
    }


    //    判断子节点是不是空
    private static boolean hasChild(List<SysMenu> list, SysMenu t) {

        return getChildList( list, t ).size() > 0 ? true : false;
    }
}
