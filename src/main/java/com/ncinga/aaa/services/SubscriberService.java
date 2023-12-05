package com.ncinga.aaa.services;

import com.ncinga.aaa.dtos.*;
import com.ncinga.aaa.dtos.request.PaginationRequestDto;
import com.ncinga.aaa.dtos.response.SubscriberRecordsDto;
import com.ncinga.aaa.entity.*;
import com.ncinga.aaa.interfaces.ISubscriber;
import com.ncinga.aaa.repository.NASWhitelistRepository;
import com.ncinga.aaa.repository.SubscriberParameterRepository;
import com.ncinga.aaa.repository.SubscriberPlanRepository;
import com.ncinga.aaa.repository.SubscriberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class SubscriberService implements ISubscriber {
    @Autowired
    private SubscriberRepository subscriberRepository;

    @Autowired
    private NASWhitelistRepository nasWhitelistRepository;

    @Autowired
    private SubscriberParameterRepository subscriberParameterRepository;

    @Autowired
    private SubscriberPlanRepository subscriberPlanRepository;


    @Override
    public SubscriberDto addSubscriber(SubscriberDto subscribe) {
        SubscriberEntity subscriberEntity = subscribe.toEntity(SubscriberEntity.class);
        try {

            SubscriberEntity result = subscriberRepository.save(subscriberEntity);
            if (result != null) {
                return SubscriberDto.fromEntity(result, SubscriberDto.class);
            }
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        }
        return null;
    }

    @Override
    public SubscriberRecordsDto getAllSubscribers(PaginationRequestDto paginationRequestDto) {
        try {
            PageRequest pageRequest = PageRequest.of(paginationRequestDto.getPage(), paginationRequestDto.getPageSize());
            Page<SubscriberEntity> subscriberEntities = subscriberRepository.findAll(pageRequest);
            int count = subscriberRepository.getRecordCount();
            if (subscriberEntities.hasContent()) {
                List<SubscriberDto> result = subscriberEntities.getContent().stream()
                        .map(record -> ParameterSQLDto.fromEntity(record, SubscriberDto.class))
                        .collect(Collectors.toList());
                return new SubscriberRecordsDto(result, count);
            }
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        }
        return null;
    }

    @Override
    public List<SubscriberDto> editSubscriber(SubscriberDto record) {
        try {
            List<SubscriberDto> result = new ArrayList<>();
            SubscriberEntity findRecord = subscriberRepository.findById(record.getSubscriber_id()).orElseThrow();
            findRecord.setUsername(record.getUsername());
            findRecord.setPassword(record.getPassword());
            findRecord.setStatus(record.getStatus());
            findRecord.setEmail(record.getEmail());
            findRecord.setContact_no(record.getContact_no());
            SubscriberEntity update = subscriberRepository.save(findRecord);
            SubscriberDto updateResult = ParameterSQLDto.fromEntity(update, SubscriberDto.class);
            result.add(updateResult);
            return result;

        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        }
    }

    @Override
    public List<SubscriberDto> getSubscriber(int id) {
        try {
            List<SubscriberEntity> records = subscriberRepository.findBySubscriberId(id);
            return records.stream().map(r -> PlanTypeDto.fromEntity(r, SubscriberDto.class)).collect(Collectors.toList());

        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        }
    }

    @Override
    public SubscriberParameterDto addParameter(SubscriberParameterDto subscriberParameterDto) {
        SubscriberParameterEntity subscriberParameterEntity = new SubscriberParameterEntity();
        SubscriberParameterEntityID entity = new SubscriberParameterEntityID();
        entity.setSubscriber_id(subscriberParameterDto.getSubscriber_id());
        entity.setParameter_name(subscriberParameterDto.getParameter_name());
        entity.setParameter_value(subscriberParameterDto.getParameter_value());
        entity.setReject_on_failure(subscriberParameterDto.getReject_on_failure());
        subscriberParameterEntity.setSubscriberParameterEntityID(entity);
        try {
            SubscriberParameterEntity result = subscriberParameterRepository.save(subscriberParameterEntity);
            if (result != null) {
                return SubscriberParameterDto.fromEntity(result, SubscriberParameterDto.class);
            }
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        }
        return null;
    }

    @Override
    public List<SubscriberParameterDto> editParameter(SubscriberParameterDto subscriberParameterDto) {
        return null;
    }

    @Override
    public List<SubscriberParameterDto> getParameters(int subscriberId) {
        try {
            List<SubscriberParameterEntity> records = subscriberParameterRepository.findBySubScriberId(subscriberId);
            return records.stream().map(r -> {
                SubscriberParameterDto subscriberParameterDto = new SubscriberParameterDto();
                subscriberParameterDto.setParameter_name(r.getSubscriberParameterEntityID().getParameter_name());
                subscriberParameterDto.setParameter_value(r.getSubscriberParameterEntityID().getParameter_value());
                subscriberParameterDto.setSubscriber_id(r.getSubscriberParameterEntityID().getSubscriber_id());
                subscriberParameterDto.setReject_on_failure(r.getSubscriberParameterEntityID().getReject_on_failure());
                return subscriberParameterDto;
            }).collect(Collectors.toList());
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        }
    }

    @Override
    public List<SubscriberParameterDto> getParameter(int subscriberId) {
        return null;
    }

    @Override
    public void deleteParameter(SubscriberParameterDto subscriberParameterDto) {
        try {
            subscriberParameterRepository.deleteSubscriberParameter(subscriberParameterDto.getSubscriber_id(), subscriberParameterDto.getParameter_name());
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        }
    }

    @Override
    public NASWhitelistDto addNas(NASWhitelistDto nasWhitelistDto) {
        NASWhitelistEntity nasWhitelistEntity = new NASWhitelistEntity();
        NASWhitelistEntityID id = new NASWhitelistEntityID();
        id.setSubscriber_id(nasWhitelistDto.getSubscriber_id());
        id.setNas_id_pattern(nasWhitelistDto.getNas_id_pattern());
        nasWhitelistEntity.setId(id);
        try {
            NASWhitelistEntity result = nasWhitelistRepository.save(nasWhitelistEntity);
            if (result != null) {
                return NASWhitelistDto.fromEntity(result, NASWhitelistDto.class);
            }
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        }
        return null;
    }

    @Override
    public List<NASWhitelistDto> editNas(NASWhitelistDto nasWhitelistDto) {
        try {
            return null;

        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        }
    }

    @Override
    public List<NASWhitelistDto> getNasWhitelist(int SubscriberId) {
        try {
            List<NASWhitelistEntity> records = nasWhitelistRepository.findBySubScriberId(SubscriberId);
            return records.stream().map(r -> {
                NASWhitelistDto nasWhitelistDto = new NASWhitelistDto();
                nasWhitelistDto.setNas_id_pattern(r.getId().getNas_id_pattern());
                nasWhitelistDto.setSubscriber_id(r.getId().getSubscriber_id());
                return nasWhitelistDto;
            }).collect(Collectors.toList());
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        }
    }

    @Override
    public List<NASWhitelistDto> getNasById(int subscriberId) {
        return null;
    }

    @Override
    public void deleteNas(NASWhitelistDto nasWhitelistDto) {
        try {
            nasWhitelistRepository.deleteNasWhitelist(nasWhitelistDto.getSubscriber_id(), nasWhitelistDto.getNas_id_pattern());
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        }
    }

    @Override
    public SubscriberPlanDto addPlan(SubscriberPlanDto SubscriberPlanDto) {
        SubscriberPlanEntity subscriberPlanEntity = SubscriberPlanDto.toEntity(SubscriberPlanEntity.class);
        try {

            SubscriberPlanEntity result = subscriberPlanRepository.save(subscriberPlanEntity);
            if (result != null) {
                return SubscriberDto.fromEntity(result, SubscriberPlanDto.class);
            }
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        }
        return null;
    }

    @Override
    public List<SubscriberPlanDto> editPlan(SubscriberPlanDto subscriberPlanDto) {
        SubscriberPlanEntity findUpdate = subscriberPlanRepository.findById(subscriberPlanDto.getInstance_id()).orElseThrow();
        findUpdate.setPlan_id(subscriberPlanDto.getPlan_id());
        findUpdate.setPlan_state(subscriberPlanDto.getPlan_state());
        subscriberPlanRepository.save(findUpdate);
        return null;
    }

    @Override
    public List<SubscriberPlanDto> getAllPlans(int subscriberId) {
        try {
            List<SubscriberPlanEntity> result = subscriberPlanRepository.findBySubscriberId(subscriberId).orElseThrow();
            if (result.size() > 0) {
                return result.stream().map(r -> SubscriberPlanDto.fromEntity(r, SubscriberPlanDto.class)).collect(Collectors.toList());
            }
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        }
        return null;
    }

    @Override
    public List<SubscriberPlanDto> getPlan(int instanceId) {
        try {
            List<SubscriberPlanDto> result = new ArrayList<>();
            SubscriberPlanEntity subscriberPlanEntity = subscriberPlanRepository.findById(instanceId).orElseThrow();
            SubscriberPlanDto record = SubscriberPlanDto.fromEntity(subscriberPlanEntity, SubscriberPlanDto.class);
            result.add(record);
            return result;

        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        }
    }

    @Override
    public void deletePlan(int instanceId) {
        try {
            subscriberPlanRepository.deleteById(instanceId);
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        }
    }

    @Override
    public void deleteSubscriber(int id) {
        try {
            subscriberRepository.deleteBySubscriberId(id);
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        }
    }
}
