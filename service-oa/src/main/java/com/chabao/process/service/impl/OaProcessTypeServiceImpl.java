package com.chabao.process.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.chabao.model.process.ProcessType;
import com.chabao.process.mapper.OaProcessTypeMapper;
import com.chabao.process.service.OaProcessTypeService;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 审批类型 服务实现类
 * </p>
 *
 * @author chabao
 * @since 2023-08-15
 */
@Service
public class OaProcessTypeServiceImpl extends ServiceImpl<OaProcessTypeMapper, ProcessType> implements OaProcessTypeService {

}
