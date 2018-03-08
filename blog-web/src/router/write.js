/**
 * Created by SNOW on 2018.01.27.
 */
import WRITE from '@/component/write/index'
import editor from '@/component/write/editor'
import publish from '@/component/write/publish'

export default {
  path: '/write',
  component: WRITE,
  children: [
    {
      path: '/', redirect: '/editor'
    },
    {
      path: '/editor', component: editor, name: 'editor'
    },
    {
      path: '/publish', component: publish, name: 'publish'
    }
  ]
}
