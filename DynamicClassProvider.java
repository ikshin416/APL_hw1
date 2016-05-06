package apl_hw1;

import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Map;

public class DynamicClassProvider {
	
	public static Map<Pair<String, String>, String> _providerMap = new HashMap<Pair<String, String>, String>();
	public static Map<Pair<String, String>, WeakReference<IPrintable>> _cache = new HashMap<Pair<String, String>, WeakReference<IPrintable>>();
	
	public static void registerProvider(String _nickName, String _realName, String _classPath){
		Pair<String, String> key = new Pair<String, String>(_nickName, _realName);
		DynamicClassProvider._providerMap.put(key, _classPath);
		System.out.println("[" + _classPath +"," + key + "] is registed");
	}
	
	public static Object newInstance(String _nickName, String _realName){
		Pair<String, String> key = new Pair<String, String>(_nickName, _realName);
		WeakReference<IPrintable> _instanceCache = DynamicClassProvider._cache.get(key);

		if(_instanceCache != null){
			IPrintable _object = _instanceCache.get();
			System.out.println("FAIL - This instance is registed already.");
			return _object;
		}
		else{

			String _classPath = DynamicClassProvider._providerMap.get(key);
			Class<?> _class;
			IPrintable _object = null;
			try {
				_class = Class.forName(_classPath);
				try {
					_object = (IPrintable)_class.newInstance();
					WeakReference<IPrintable> _weak = new WeakReference<IPrintable>(_object);
					DynamicClassProvider._cache.put(key, _weak);
					System.out.println("SUCCESS - This instance is registed");
				} catch (InstantiationException | IllegalAccessException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return _object;
		}
		
	}

}
