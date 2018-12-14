package com.marathon.manage.controller.volunteer;

import com.google.common.collect.Lists;
import com.marathon.manage.controller.volunteer.qvo.QueryVolunteerInfoVO;
import com.marathon.manage.refactor.pojo.VolunteerInfo;
import com.marathon.manage.service.volunteer.VolunteerService;
import com.marathon.manage.vo.BaseResultBean;
import com.marathon.manage.vo.BaseTreeGridVO;
import com.marathon.manage.vo.SimpleResultBean;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * 志愿者需求
 * Created by cui on 2018/5/22.
 */
@Controller
@RequestMapping("volunteer")
public class VolunteerController {

    private Logger logger = LoggerFactory.getLogger(getClass());

    @Autowired
    private VolunteerService volunteerService;


    @RequestMapping("init/{marathonId}")
    public ModelAndView init(HttpServletRequest request, @PathVariable String marathonId) {
        ModelAndView modelAndView = new ModelAndView("volunteer/volunteerinfo");
        modelAndView.addObject("marathonId", marathonId);
        return modelAndView;
    }

    /**
     * 查询某赛事志愿者需求信息
     *
     * @param request
     * @param marathonId
     * @return
     */
    @RequestMapping("query/{marathonId}")
    @ResponseBody
    public BaseResultBean queryVolunteers(HttpServletRequest request, @PathVariable String marathonId) {
        SimpleResultBean<List<QueryVolunteerInfoVO>> result = new SimpleResultBean<>();

        List<VolunteerInfo> lstVolunteer = volunteerService.queryForVolunteers(marathonId);

        List<QueryVolunteerInfoVO> lstVO = Lists.newArrayList();

        if (lstVolunteer.size() > 0) {

            for (VolunteerInfo volunteer : lstVolunteer) {
                QueryVolunteerInfoVO vo = new QueryVolunteerInfoVO();
                vo.setId(String.valueOf(volunteer.getGroupId()));
                vo.setGroupName(volunteer.getGroupName());

                QueryVolunteerInfoVO child=new QueryVolunteerInfoVO();
                BeanUtils.copyProperties(volunteer,child);

                if (!lstVO.contains(vo)) {
                    vo.getChildren().add(child);
                    lstVO.add(vo);
                } else {
                    int index = lstVO.indexOf(vo);
                    QueryVolunteerInfoVO infoVO = lstVO.get(index);
                    infoVO.getChildren().add(child);
                }
            }
        }
        result.setObject(lstVO);
        return result;

    }
}
