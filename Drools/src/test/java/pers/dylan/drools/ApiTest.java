package pers.dylan.drools;

import com.alibaba.fastjson.JSON;
import org.junit.Before;
import org.junit.Test;
import org.kie.api.KieServices;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;
import pers.dylan.drools.model.Policy;

public class ApiTest {

    private KieContainer kieContainer;
    private Policy policy;

    @Before
    public void init() {
        KieServices kieServices = KieServices.Factory.get();
        kieContainer = kieServices.getKieClasspathContainer();

        policy = new Policy();
        policy.setSex("男");
        policy.setAge(16);
        policy.setUserSingle(false);
        policy.setUserMarry(false);
        policy.setUserParenting(false);
        System.out.println("决策请求：" + JSON.toJSONString(policy));
    }

    @Test
    public void test_drools() {
        KieSession kieSession = kieContainer.newKieSession("all-rules");
        kieSession.insert(policy);
        Result result = new Result();
        kieSession.setGlobal("res", result);
        int count = kieSession.fireAllRules();

        System.out.println("Fire rule(s)：" + count);
        System.out.println("决策结果(Drools)：" + result);

        kieSession.dispose();
    }
}
